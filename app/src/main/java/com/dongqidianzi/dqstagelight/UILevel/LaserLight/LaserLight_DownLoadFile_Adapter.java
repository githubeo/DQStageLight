package com.dongqidianzi.dqstagelight.UILevel.LaserLight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dongqidianzi.dqstagelight.ModelLevel.DownLoadFileItem;
import com.dongqidianzi.dqstagelight.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class LaserLight_DownLoadFile_Adapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<DownLoadFileItem> dataList;
    public LaserLight_DownLoadFile_Adapter(Context context,List<DownLoadFileItem> dataList)
    {
        this.mInflater = LayoutInflater.from(context);
        this.dataList=dataList;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void add(DownLoadFileItem dfi)
    {
        dataList.add(dfi);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        final int index=i;
        if (view == null) {
            holder=new ViewHolder();
            view = mInflater.inflate(R.layout.laserlight_downloadfile_adapter_item, null);
            holder.isChecked_chk= (CheckBox) view.findViewById(R.id.downLoadFile_chk);
            holder.fileName_tv=(TextView)view.findViewById(R.id.fileName_tv);
            view.setTag(holder);
        }
        else
          holder=(ViewHolder)view.getTag();

        holder.isChecked_chk.setChecked(dataList.get(i).getIsChecked());
        holder.fileName_tv.setText(dataList.get(i).getFileName());

        holder.isChecked_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                dataList.get(index).setChecked(b);
            }
        });
        return view;
    }

    public final class ViewHolder
    {
        public CheckBox isChecked_chk;
        public TextView fileName_tv;
    }
}
