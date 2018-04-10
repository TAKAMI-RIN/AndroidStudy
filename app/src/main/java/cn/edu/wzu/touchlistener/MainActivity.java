package cn.edu.wzu.touchlistener;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.lblOutput);
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.setOnTouchListener(this);
        frame.setOnClickListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() != R.id.frame) return false;
        int act = event.getAction();
        switch (act) {
            case MotionEvent.ACTION_DOWN:
                output.setText("ACTION_DOWN");
                output.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_UP:
                output.setText("ACTION_UP");
                output.setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_MOVE:
                float evt_x = event.getX();
                float evt_y = event.getY();
                int v_w = v.getWidth();
                int v_h = v.getHeight();
                output.setText("evt_x="+evt_x+"\nevt_y="+evt_y+"\nw="+v_w+"\nh="+v_h);
                if (evt_x>=0 && evt_x<=v_w && evt_y>=0 &&  evt_y<=v_h)
                    output.setTextColor(Color.RED);
                else
                    output.setTextColor(Color.GREEN);
                break;
        }
        return false;
        // return true;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() != R.id.frame) return;
        output.setText("Click");
        output.setTextColor(Color.BLUE);
    }
}
