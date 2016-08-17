package com.daniel.dialogdemo;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by FengWendan on 2016/8/4 0004.
 * Make a dialog with the same style,and you can customize your own content of it.
 */
public class JzbDialog extends DialogFragment {
    private Context mContext;
    private FrameLayout mFlDialogContent;
    private Button mBtnCancel;
    private Button mBtnConfirm;
    private Dialog mDialog;
    private View mView;
    public static final int BUTTON_CONFIRM = R.id.btn_confirm;
    public static final int BUTTON_CANCEL = R.id.btn_cancel;
    private View mVerticalLine;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mDialog = getDialog();
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setCanceledOnTouchOutside(true);
        initView(mView);
        return mView;
    }

    private void initView(View view) {
        mFlDialogContent = (FrameLayout) view.findViewById(R.id.fl_dialog_content);
        mBtnCancel = (Button) view.findViewById(R.id.btn_cancel);
        mBtnConfirm = (Button) view.findViewById(R.id.btn_confirm);
        mVerticalLine = mView.findViewById(R.id.vertical_line);
    }

    public JzbDialog setContext(Context context) {
        this.mContext = context;
        mView = View.inflate(context, R.layout.base_dialog, null);
        initView(mView);
        return this;
    }

    public JzbDialog setContentView(View view) {
        checkContext();
        mFlDialogContent.addView(view);
        return this;
    }

    public JzbDialog setContentView(String msg) {
        checkContext();
        TextView textView = new TextView(mContext);
        textView.setText(msg);
        textView.setGravity(Gravity.CENTER);
        mFlDialogContent.addView(textView);
        return this;
    }

    public JzbDialog setContentView(int resId) {
        checkContext();
        mFlDialogContent.addView(View.inflate(mContext, resId, null));
        return this;
    }

    public JzbDialog setPositiveButton(final View.OnClickListener onPositiveButtonListener) {
        checkContext();
        if (onPositiveButtonListener == null) {
            hideBtnConfirm();
        }
        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                onPositiveButtonListener.onClick(mBtnConfirm);
            }
        });
        return this;
    }

    public JzbDialog setNegativeButton(final View.OnClickListener onNegativeButtonListener) {
        checkContext();
        if (onNegativeButtonListener == null) {
            hideBtnCancel();
        }
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                onNegativeButtonListener.onClick(mBtnCancel);
            }
        });
        return this;
    }

    private void checkContext() {
        if (mContext == null) {
            throw new IllegalStateException("Please invoke method setContext() before do other settings.");
        }
    }

    private void hideBtnConfirm() {
        mVerticalLine.setVisibility(View.GONE);
        mBtnConfirm.setVisibility(View.GONE);
    }

    private void hideBtnCancel() {
        mBtnCancel.setVisibility(View.GONE);
        mVerticalLine.setVisibility(View.GONE);
    }

    public void show() {
        show(null);
    }

    public void show(String tag) {
        Activity activity = (Activity) mContext;
        show(activity.getFragmentManager(), tag);
    }
}
