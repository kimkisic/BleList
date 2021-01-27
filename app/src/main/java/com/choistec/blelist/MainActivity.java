package com.choistec.blelist;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter mBluetoothAdapter;

    BluetoothLeScanner mBluetoothLeScanner;

    BluetoothLeAdvertiser mBluetoothLeAdvertiser;

    private static final int PERMISSIONS = 100;

    private ArrayList<Beacon> mDeviceItemArr = new ArrayList<>();

    Vector<Beacon> beacon;

    BeaconAdapter beaconAdapter;

    ListView beaconListView;

    ScanSettings.Builder mScanSettings;

    List<ScanFilter> scanFilters;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.KOREAN);

    private int check = 0;

    private Button reScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reScan = (Button) findViewById(R.id.re_scan);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS);
        beaconListView = (ListView) findViewById(R.id.beaconListView);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
        mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
        beacon = new Vector<>();
        mScanSettings = new ScanSettings.Builder();
        mScanSettings.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY);
        // 얘는 스캔 주기를 2초로 줄여주는 Setting입니다.
        // 공식문서에는 위 설정을 사용할 때는 다른 설정을 하지 말고
        // 위 설정만 단독으로 사용하라고 되어 있네요 ^^
        // 위 설정이 없으면 테스트해 본 결과 약 10초 주기로 스캔을 합니다.
        ScanSettings scanSettings = mScanSettings.build();

        scanFilters = new Vector<>();
        ScanFilter.Builder scanFilter = new ScanFilter.Builder();
//        scanFilter.setDeviceName("Thermosafer 60021");
//        scanFilter.setDeviceAddress("특정 기기의 MAC 주소"); //ex) 00:00:00:00:00:00
        ScanFilter scan = scanFilter.build();
        scanFilters.add(scan);
        mBluetoothLeScanner.startScan(scanFilters, scanSettings, mScanCallback);
        // filter와 settings 기능을 사용하지 않을 때는
//        mBluetoothLeScanner.startScan(mScanCallback); //처럼 사용하시면 돼요.
    }

    ScanCallback mScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            try {
                ScanRecord scanRecord = result.getScanRecord();
                Log.d("getTxPowerLevel()",scanRecord.getTxPowerLevel()+"");
                byte[] aaa = scanRecord.getBytes();
                // 써모세이퍼 rawdata의 총 byte길이는 62
//                Log.d("myLog", aaa.length + "");
                int s1 = aaa[0] & 0xFF;
                int s2 = aaa[1] & 0xFF;
                int s3 = aaa[2] & 0xFF;
                int s4 = aaa[3] & 0xFF;
                int s5 = aaa[4] & 0xFF;
                int s6 = aaa[5] & 0xFF;
                int s7 = aaa[6] & 0xFF;
                int s8 = aaa[7] & 0xFF;
                int s9 = aaa[8] & 0xFF;
                int s10 = aaa[9] & 0xFF;
                int s11 = aaa[10] & 0xFF;
                int s12 = aaa[11] & 0xFF;
                int s13 = aaa[12] & 0xFF;
                int s14 = aaa[13] & 0xFF;
                int s15 = aaa[14] & 0xFF;
                int s16 = aaa[15] & 0xFF;
                int s17 = aaa[16] & 0xFF;
                int s18 = aaa[17] & 0xFF;
                int s19 = aaa[18] & 0xFF;
                int s20 = aaa[19] & 0xFF;
                int s21 = aaa[20] & 0xFF;
                int s22 = aaa[21] & 0xFF;
                int s23 = aaa[22] & 0xFF;
                int s24 = aaa[23] & 0xFF;
                int s25 = aaa[24] & 0xFF;
                int s26 = aaa[25] & 0xFF;
                int s27 = aaa[26] & 0xFF;
                int s28 = aaa[27] & 0xFF;
                int s29 = aaa[28] & 0xFF;
                int s30 = aaa[29] & 0xFF;
                int s31 = aaa[30] & 0xFF;
                int s32 = aaa[31] & 0xFF;
                int s33 = aaa[32] & 0xFF;
                int s34 = aaa[33] & 0xFF;
                int s35 = aaa[34] & 0xFF;
                int s36 = aaa[35] & 0xFF;
                int s37 = aaa[36] & 0xFF;
                int s38 = aaa[37] & 0xFF;
                int s39 = aaa[38] & 0xFF;
                int s40 = aaa[39] & 0xFF;
                int s41 = aaa[40] & 0xFF;
                int s42 = aaa[41] & 0xFF;
                int s43 = aaa[42] & 0xFF;
                int s44 = aaa[43] & 0xFF;
                int s45 = aaa[44] & 0xFF;
                int s46 = aaa[45] & 0xFF;
                int s47 = aaa[46] & 0xFF;
                int s48 = aaa[47] & 0xFF;
                int s49 = aaa[48] & 0xFF;
                int s50 = aaa[49] & 0xFF;
                int s51 = aaa[50] & 0xFF;
                int s52 = aaa[51] & 0xFF;
                int s53 = aaa[52] & 0xFF;
                int s54 = aaa[53] & 0xFF;
                int s55 = aaa[54] & 0xFF;
                int s56 = aaa[55] & 0xFF;
                int s57 = aaa[56] & 0xFF;
                int s58 = aaa[57] & 0xFF;
                int s59 = aaa[58] & 0xFF;
                int s60 = aaa[59] & 0xFF;
                int s61 = aaa[60] & 0xFF;
                int s62 = aaa[61] & 0xFF;

                final String rawData = "[ " + s1 + ", " + s2 + ", " + s3 + ", "+ s4 + ", " + s5 + ", "
                        + s6 + ", " + s7 + ", " + s8 + ", " + s9 + ", " + s10 + ", " + s11 + ", " +s12 + ", "
                        + s13 + ", " + s14 + ", " + s15 + ", " + s16 + ", " + s17 + ", " + s18 + ", " + s19 + ", "
                        + s20 + ", " + s21 + ", " + s22 + ", " + s23 + ", " + s24 + ", " + s25 + ", " + s26 + ", "
                        + s27 + ", " + s28 + ", " + s29 + ", " + s30 + ", " + s31 + ", " + s32 + ", " + s33 + ", "
                        + s34 + ", " + s35 + ", " + s36 + ", " + s37 + ", " + s38 + ", " + s39 + ", " + s40 + ", "
                        + s41 + ", " + s42 + ", " + s43 + ", " + s44 + ", " + s45 + ", " + s46 + ", " + s47 + ", "
                        + s48 + ", " + s49 + ", " + s50 + ", " + s51 + ", " + s52 + ", " + s53 + ", " + s54 + ", "
                        + s55 + ", " + s56 + ", " + s57 + ", " + s58 + ", " + s59 + ", " + s60 + ", " + s61 + ", "
                        + s62 + " ]";
                if (s20 < 0) {
                    s20 = s20 + 256;
                }
                final float temp = ((s19*256) + s20)/100f;
                Log.d("myLog", rawData);
                Log.d("temp", "temp : " + ((s19*256) + s20)/100.0);

                final int battery = s18;


//                Log.d("getByte()", "[ " + s1 + ", " + s2 + ", " + s3 + ", "+ s4 + ", " + s5 + ", "
//                        + s6 + ", " + s7 + ", " + s8 + ", " + s9 + ", " + s10 + ", " + s11 + ", " +s12 + ", "
//                        + s13 + ", " + s14 + ", " + s15 + ", " + s16 + ", " + s17 + ", " + s18 + ", " + s19 + ", "
//                        + s20 + ", " + s21 + ", " + s22 + ", " + s23 + ", " + s24 + ", " + s25 + ", " + s26 + ", "
//                        + s27 + ", " + s28 + ", " + s29 + ", " + s30 + ", " + s31 + ", " + s32 + ", " + s33 + ", "
//                        + s34 + ", " + s35 + ", " + s36 + ", " + s37 + ", " + s38 + ", " + s39 + ", " + s40 + ", "
//                        + s41 + ", " + s42 + ", " + s43 + ", " + s44 + ", " + s45 + ", " + s46 + ", " + s47 + ", "
//                        + s48 + ", " + s49 + ", " + s50 + ", " + s51 + ", " + s52 + ", " + s53 + ", " + s54 + ", "
//                        + s55 + ", " + s56 + ", " + s57 + ", " + s58 + ", " + s59 + ", " + s60 + ", " + s61 + ", "
//                        + s62 + " ]");
                Log.d("onScanResult()", result.getDevice().getAddress() + "\n" + result.getRssi() + "\n" + result.getDevice().getName()
                        + "\n" + result.getDevice().getBondState() + "\n" + result.getDevice().getType());

                beaconAdapter = new BeaconAdapter(beacon, getLayoutInflater());
                beaconListView.setAdapter(beaconAdapter);

                final ScanResult scanResult = result;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(!(scanResult.getDevice().getName() == null)) {
                                    if (scanResult.getDevice().getName().startsWith("Thermosafer")) {
//                                        if (beaconListView.getCount() != 0) {
//                                            beacon.add(0, new Beacon(scanResult.getDevice().getAddress(), scanResult.getRssi(), simpleDateFormat.format(new Date()), scanResult.getDevice().getName(), rawData, temp, battery));
//                                            beaconAdapter.notifyDataSetChanged();
//                                        }
                                            for (int i = 0; i < beaconAdapter.getCount(); i++) {
                                                Log.d("myLog", beaconAdapter.getAddress(i));
                                                Log.d("myLog", scanResult.getDevice().getAddress());
                                                Log.d("myLog", String.valueOf(beaconAdapter.getAddress(i).equals(scanResult.getDevice().getAddress())));
                                                if (beaconAdapter.getAddress(i).equals(scanResult.getDevice().getAddress())) {
                                                    beacon.set(i, new Beacon(scanResult.getDevice().getAddress(), scanResult.getRssi(), simpleDateFormat.format(new Date()), scanResult.getDevice().getName(), rawData, temp, battery));
                                                    check = 1;
                                                    beaconAdapter.notifyDataSetChanged();
//                                                    Toast.makeText(getApplicationContext(), beaconListView.getCount() + "", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        if (check == 0) {
                                            beacon.add(0, new Beacon(scanResult.getDevice().getAddress(), scanResult.getRssi(), simpleDateFormat.format(new Date()), scanResult.getDevice().getName(), rawData, temp, battery));
                                            beaconAdapter.notifyDataSetChanged();
                                        }
                                    }
                                }
                                reScan.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        beacon.clear();
                                        beaconAdapter.notifyDataSetChanged();
                                        check = 0;
//                                        if(!(scanResult.getDevice().getName() == null)) {
//                                            if (scanResult.getDevice().getName().startsWith("Thermosafer")) {
//                                                beacon.add(0, new Beacon(scanResult.getDevice().getAddress(), scanResult.getRssi(), simpleDateFormat.format(new Date()), scanResult.getDevice().getName(), rawData, temp, battery));
//                                                beaconAdapter.notifyDataSetChanged();
//                                            }
//                                        }
                                    }
                                });
                                beaconListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                    @Override
                                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        beacon.remove(i);
                                        beaconAdapter.notifyDataSetChanged();
                                        return true;
                                    }
                                });
                                beaconListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                        Intent intent = new Intent(getApplicationContext(), ConnectActivity.class);
                                        intent.putExtra("deviceName", scanResult.getDevice().getName());
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
            Log.d("onBatchScanResults", results.size() + "");
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            Log.d("onScanFailed()", errorCode+"");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBluetoothLeScanner.stopScan(mScanCallback);
    }

    }
