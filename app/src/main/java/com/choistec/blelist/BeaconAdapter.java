package com.choistec.blelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

public class BeaconAdapter extends BaseAdapter {

    private Vector<Beacon> beacons;
    private LayoutInflater layoutInflater;

    public BeaconAdapter(Vector<Beacon> beacons, LayoutInflater layoutInflater) {
        this.beacons = beacons;
        this.layoutInflater = layoutInflater;
    }

    public String getAddress(int pos) {
        return beacons.get(pos).getAddress();
    }

    @Override
    public int getCount() {
        return beacons.size();
    }

    @Override
    public Object getItem(int position) {
        return beacons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BeaconHolder beaconHolder;
        if (convertView == null) {
            beaconHolder = new BeaconHolder();
            convertView = layoutInflater.inflate(R.layout.item, parent, false);
            beaconHolder.address = convertView.findViewById(R.id.address);
            beaconHolder.rssi = convertView.findViewById(R.id.rssi);
            beaconHolder.time = convertView.findViewById(R.id.time);
            beaconHolder.name = convertView.findViewById(R.id.name);
            beaconHolder.rawData = convertView.findViewById(R.id.raw_data);
            beaconHolder.temp = convertView.findViewById(R.id.temp);
            beaconHolder.battery = convertView.findViewById(R.id.battery);
            convertView.setTag(beaconHolder);
        } else {
            beaconHolder = (BeaconHolder)convertView.getTag();
        }

            beaconHolder.time.setText("Time : " + beacons.get(position).getNow());
            beaconHolder.address.setText("Mac : " + beacons.get(position).getAddress());
            beaconHolder.rssi.setText("RSSI : " + beacons.get(position).getRssi() + "dBm");
            beaconHolder.name.setText("name : " + beacons.get(position).getName());
            beaconHolder.rawData.setText("RawData : " + beacons.get(position).getRawData());
            beaconHolder.temp.setText("temp : " + beacons.get(position).getTemp());
            beaconHolder.battery.setText("battery : " + beacons.get(position).getBattery() + "%");

        return convertView;
    }

    private class BeaconHolder {
        TextView address;
        TextView rssi;
        TextView time;
        TextView name;
        TextView rawData;
        TextView temp;
        TextView battery;
    }

}
