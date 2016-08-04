package com.daniel.dialogdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button mShowDialog;
    private Button mShowDialog1;
    private Button mShowDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
    }

    private void initView() {
        mShowDialog = (Button) findViewById(R.id.show_dialog);
        mShowDialog.setOnClickListener(this);
        mShowDialog1 = (Button) findViewById(R.id.show_dialog_1);
        mShowDialog1.setOnClickListener(this);
        mShowDialog2 = (Button) findViewById(R.id.show_dialog_2);
        mShowDialog2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_dialog:
                showDialog();
                break;
            case R.id.show_dialog_1:
                showDialog1();
                break;
            case R.id.show_dialog_2:
                showDialog2();
                break;

            case JzbDialog.BUTTON_CONFIRM:
                Toast.makeText(mContext, "点击确定", Toast.LENGTH_SHORT).show();
                break;
            case JzbDialog.BUTTON_CANCEL:
                Toast.makeText(mContext, "点击取消", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void showDialog() {
        JzbDialog dialog = new JzbDialog();
        dialog.setContext(this)
                .setContentView(R.layout.new_recruit_dialog)
                .setPositiveButton(this)
                .setNegativeButton(this)
                .show();
    }

    private void showDialog1() {
        TextView textView = new TextView(mContext);
        textView.setText("Dialog Demo");
        JzbDialog dialog = new JzbDialog();
        dialog.setContext(this)
                .setContentView(textView)
                .setPositiveButton(this)
                .setNegativeButton(null)
                .show();

    }

    private void showDialog2() {
        JzbDialog dialog = new JzbDialog();
        dialog.setContext(this)
                .setContentView("Dialog Demo")
                .setPositiveButton(null)
                .setNegativeButton(this)
                .show();
    }
}
