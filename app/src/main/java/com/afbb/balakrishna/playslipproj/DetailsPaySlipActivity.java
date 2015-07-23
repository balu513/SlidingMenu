package com.afbb.balakrishna.playslipproj;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afbb.balakrishna.playslipproj.core.Employee;
import com.afbb.balakrishna.playslipproj.core.PayslipBean;
import com.afbb.balakrishna.playslipproj.utils.Utils;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class DetailsPaySlipActivity extends ActionBarActivity {

    private WebView webview;
    private PayslipBean payslipBean;
    private String TAG = "DetailsPaySlipActivity";
    private String html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pay_slip);
        webview = (WebView) findViewById(R.id.webview_payslip_act);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            payslipBean = bundle.getParcelable("payslip");
            displayPlaySlipFormat(payslipBean);
        }
        webview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                webview.getSettings().setLoadWithOverviewMode(true);
                webview.getSettings().setUseWideViewPort(true);

                AlertDialog.Builder builder = new AlertDialog.Builder(DetailsPaySlipActivity.this);
                final AlertDialog alertDialog = builder.create();
                LayoutInflater inflater = LayoutInflater.from(DetailsPaySlipActivity.this);
                View view = inflater.inflate(R.layout.pdfsave, null);
                alertDialog.setView(view);
                final EditText et_save = (EditText) view.findViewById(R.id.et_pdf_save);
                Button btnSave = (Button) view.findViewById(R.id.btn_pdf_save);
                Button btnCancel = (Button) view.findViewById(R.id.btn_pdf_cancel);
                FileOutputStream outputStream = null;
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String filename = et_save.getText().toString();
                        webview.setDrawingCacheEnabled(true);
                        final Bitmap bitmap = webview.getDrawingCache();
                        savePdf(filename, html);
                        Toast.makeText(getApplicationContext(), "Payslip saved.", Toast.LENGTH_SHORT).show();
                        alertDialog.cancel();
                    }

                });

                alertDialog.show();
                return false;
            }
        });
    }


    public void savePdf(String filename, String html) {

        try {

            //Open a new document instance
            Document doc = new Document();

            //We convert the string to a byte array, so we can input it to the XMLWorker instance
            InputStream in = new ByteArrayInputStream(html.getBytes());

            File file = new File(Environment.getExternalStorageDirectory(), "Payslips");
            if (!file.exists()) {
                file.mkdir();
            }
            //We write the file to a app accesbile location
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/Payslips" + "/" + filename + ".pdf"));

            //open the document to write
            doc.open();

            //parser and write the file
            XMLWorkerHelper.getInstance().parseXHtml(pdf, doc, in);

            doc.close();
            in.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    private void displayPlaySlipFormat(PayslipBean payslipBean) {
        Employee employee = Utils.getInstance(getApplicationContext()).getEmployeePreference();
        payslipBean.setEmpId(employee.getEmpId());
        payslipBean.setName(employee.getName());
        payslipBean.setDeptName(employee.getDept());
        payslipBean.setDesignation(employee.getDesignation());
        payslipBean.setPanNum(employee.getPanNo());
        payslipBean.setAccNum(employee.getAccountNo());
        payslipBean.setBranch(employee.getBranch());
        payslipBean.setDoj(employee.getDOJ());
        payslipBean.setDor(employee.getDOR());
        html = payslipBean.display();
        webview.getSettings().setBuiltInZoomControls(true);
        webview.loadData(html, "text/html; charset=UTF-8", null);

    }
}
