package com.afbb.balakrishna.playslipproj.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.afbb.balakrishna.playslipproj.R;
import com.afbb.balakrishna.playslipproj.core.PayslipBean;

import java.util.List;

public class PayslipsAdapter extends BaseAdapter {

    private Context context;
    private List<PayslipBean> list;

    public PayslipsAdapter(Context context, List<PayslipBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public PayslipBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_payslip_months, null);
            holder.tvFrom = (TextView) convertView.findViewById(R.id.tv_fromdate);
            holder.tvTo = (TextView) convertView.findViewById(R.id.tv_todate);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvFrom.setText(list.get(position).getFromDate());
        holder.tvTo.setText(list.get(position).getToDate());
        return convertView;
    }

    class ViewHolder {
        TextView tvFrom, tvTo;
    }
}