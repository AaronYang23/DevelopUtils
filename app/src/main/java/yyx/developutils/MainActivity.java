package yyx.developutils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import yyx.widget.text.TextArrowGroupView;

public class MainActivity extends AppCompatActivity {

    boolean temp = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextArrowGroupView textArrowGroupView  = findViewById(R.id.textArrowGroupView);
//                setIconPosition(!temp,textArrowGroupView,textArrowGroupView.getTextView(),textArrowGroupView.getIconView());
                textArrowGroupView.setIconPosition(!temp);
                temp = !temp;
            }
        });
    }


    /**
     * 位置调整
     *
     * @param isStartIcon 是否图标在文字左边
     */
    public void setIconPosition(boolean isStartIcon, ConstraintLayout textArrowGroupView,TextView text, ImageView icon) {


        isStartIcon = true;
//
//
//        removeAllViews();
//        binding.icon.getParent()
//
//        if(isStartIcon){
//            addView(binding.icon);
//            addView(binding.text);
//        }else {
//            addView(binding.text);
//            addView(binding.icon);
//        }
//
//        for(binding.textArrowGroupView.getChildCount())
//        isStartIcon = true;
        TransitionManager.beginDelayedTransition(textArrowGroupView);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(textArrowGroupView);
        constraintSet.clear(text.getId());
        constraintSet.clear(icon.getId());
        if (isStartIcon) {
            //文案右图标左
            constraintSet.connect(icon.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
            constraintSet.connect(icon.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(icon.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
//
//            constraintSet.constrainWidth(binding.tvTitlePloyDesc.id, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//            constraintSet.constrainHeight(binding.tvTitlePloyDesc.id, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//            constraintSet.constrainWidth(binding.clTag.id, ConstraintLayout.LayoutParams.MATCH_PARENT)
//            constraintSet.constrainHeight(binding.clTag.id, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//            set.connect(binding.tvTitlePloyDesc.id, ConstraintSet.START, binding.tvTitlePloy.id, ConstraintSet.START)
//            set.connect(binding.tvTitlePloyDesc.id, ConstraintSet.TOP, binding.tvTitlePloy.id, ConstraintSet.BOTTOM)
//            set.connect(binding.clTag.id, ConstraintSet.TOP, binding.tvTitlePloyDesc.id, ConstraintSet.BOTTOM, ScreenUtil.dp2px(4F))
//            set.applyTo(binding.clPloyMain)

            constraintSet.connect(text.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(text.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
            constraintSet.connect(text.getId(), ConstraintSet.LEFT, icon.getId(), ConstraintSet.RIGHT);
//            constraintSet.connect(binding.text.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        }
//        else {
//            //文案左图标右
//            constraintSet.connect(binding.text.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
//            constraintSet.connect(binding.icon.getId(), ConstraintSet.START, binding.text.getId(), ConstraintSet.END);
//            constraintSet.applyTo(binding.getRoot());
//        }
        constraintSet.applyTo(textArrowGroupView);
    }
}