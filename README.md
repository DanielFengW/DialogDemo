# DialogDemo
Simple dialog for Android with simple style,and it is also simpe to use.

# What looks like
![image](https://github.com/DanielFengW/DialogDemo/blob/master/Screenshot_2016-08-04-13-06-21-281_com.daniel.dialogdemo.png)
![image](https://github.com/DanielFengW/DialogDemo/blob/master/Screenshot_2016-08-04-13-06-30-779_com.daniel.dialogdemo.png)
![image](https://github.com/DanielFengW/DialogDemo/blob/master/Screenshot_2016-08-04-13-06-40-556_com.daniel.dialogdemo.png)
![image](https://github.com/DanielFengW/DialogDemo/blob/master/Screenshot_2016-08-04-13-06-47-559_com.daniel.dialogdemo.png)


# How to use

        JzbDialog dialog = new JzbDialog();
        dialog.setContext(this)
                .setContentView(R.layout.new_recruit_dialog)
                .setPositiveButton(this)
                .setNegativeButton(this)
                .show();

