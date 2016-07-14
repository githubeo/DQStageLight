package com.dongqidianzi.dqstagelight.UILevel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.dongqidianzi.dqstagelight.BusinessLogicLevel.CommHandleManager;
import com.dongqidianzi.dqstagelight.BusinessLogicLevel.DeviceConfigManager;
import com.dongqidianzi.dqstagelight.BusinessLogicLevel.FilesLogicManager;
import com.dongqidianzi.dqstagelight.R;
import com.dongqidianzi.dqstagelight.SystemDefinedLevel.FilesManager.FileHelper;
import com.dongqidianzi.dqstagelight.UILevel.LaserLight.Bluetooth_Main_Activity;
import com.dongqidianzi.dqstagelight.UILevel.LaserLight.LaserLight_Main_Activity;

/**
 * Created by Administrator on 2015/10/8.
 */
public class Main_Activity extends Activity {

    private ImageView laserLightBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        laserLightBtn = (ImageView)this.findViewById(R.id.laserLightBtn);
        laserLightBtn.setOnClickListener(chickLaserLightBtn);

       init();
    ActivityLoadedFinish();
    }

    private void init()
    {
        initDefaultDir();

        CommHandleManager commHandleManager=new CommHandleManager(this);

//               Intent intent=new Intent(Main_Activity.this,System_Selector_Activity.class);
//        startActivity(intent);
    }
    private void initDefaultDir()
    {
        String configFilePath= FilesLogicManager.getDefPath()+"/"+FilesLogicManager.configFileDir;
        FileHelper.isExistCreatePath(configFilePath);

        DeviceConfigManager deviceConfigManager=new DeviceConfigManager(this);
        deviceConfigManager.configDevice("1.0");
    }
    private void ActivityLoadedFinish()
    {
        Intent intent=new Intent(Main_Activity.this,Bluetooth_Main_Activity.class);
        startActivity(intent);
    }
    private View.OnClickListener chickLaserLightBtn=new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Main_Activity.this, LaserLight_Main_Activity.class);
            startActivity(intent);
        }
    };

}
