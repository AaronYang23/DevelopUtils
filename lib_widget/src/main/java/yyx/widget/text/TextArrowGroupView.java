package yyx.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import yyx.widget.R;
import yyx.widget.databinding.GroupTextArrowBinding;
import yyx.widget.text.viewutils.AyViewUtils;


/**
 * Desc: 文本+箭头/图标组合控件
 *
 * @author: Yang Yuanxiong
 * @date: 2022/6/27
 */
public class TextArrowGroupView extends ConstraintLayout {
    GroupTextArrowBinding binding;

    public TextArrowGroupView(@NonNull Context context) {
        super(context);
    }

    public TextArrowGroupView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TextArrowGroupView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.group_text_arrow, this, true);
        binding = GroupTextArrowBinding.bind(view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextArrowGroupView);
        String text = typedArray.getString(R.styleable.TextArrowGroupView_text);
        int textColor = typedArray.getColor(R.styleable.TextArrowGroupView_titleColor, Color.BLACK);
        float textSize = typedArray.getDimensionPixelSize(R.styleable.TextArrowGroupView_textSize, 0);
        Drawable icon = typedArray.getDrawable(R.styleable.TextArrowGroupView_icon);
        int iconPosition = typedArray.getInt(R.styleable.TextArrowGroupView_iconPosition, 0);
        float iconWidth = typedArray.getDimensionPixelSize(R.styleable.TextArrowGroupView_iconWidth, 0);
        float iconMargin = typedArray.getDimensionPixelSize(R.styleable.TextArrowGroupView_iconMargin, 0);
        typedArray.recycle();

        binding.text.setText(text);
        binding.text.setTextColor(textColor);
        if (textSize != 0) {
            binding.text.setTextSize(TypedValue.COMPLEX_UNIT_PX, (int) textSize);
        }
        if (icon != null) {
            binding.icon.setImageDrawable(icon);
        }
//        setIconPosition(iconPosition == 0);
        if (iconWidth != 0) {
            AyViewUtils.setWidth(binding.icon, binding.icon.getLayoutParams(), (int) iconWidth);
        }
        if (iconMargin != 0) {
            AyViewUtils.setMargin(binding.icon, (ConstraintLayout.LayoutParams) binding.icon.getLayoutParams(), (int) iconMargin, (int) iconMargin, (int) iconMargin, (int) iconMargin);
        }

    }


    /**
     * 位置调整
     *
     * @param isStartIcon 是否图标在文字左边
     */
    public void setIconPosition(boolean isStartIcon) {
//        RelativeLayout.LayoutParams textParams  = (LayoutParams) binding.text.getLayoutParams();
//        RelativeLayout.LayoutParams iconParams  = (LayoutParams) binding.icon.getLayoutParams();
//        if(isStartIcon){
//            iconParams.addRule(ALIGN_PARENT_START);
//            textParams.addRule(RelativeLayout.END_OF,binding.text.getId());
//
//        }else {
//            textParams.addRule(ALIGN_PARENT_START);
//            iconParams.addRule(RelativeLayout.END_OF,binding.text.getId());
//        }
//        binding.text.setLayoutParams(textParams);
//        binding.icon.setLayoutParams(iconParams);


//        isStartIcon = true;
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
//        TransitionManager.beginDelayedTransition(binding.textArrowGroupView);
//        ConstraintSet constraintSet = new ConstraintSet();
//        constraintSet.clone(this);
//        constraintSet.clear(R.id.text);
//        constraintSet.clear(R.id.icon);
        LayoutParams textParams = (LayoutParams) binding.text.getLayoutParams();
        LayoutParams iconParams = (LayoutParams) binding.icon.getLayoutParams();
        if (isStartIcon) {
            //文案右图标左

            textParams.startToEnd = binding.icon.getId();
            textParams.topToTop = ConstraintSet.PARENT_ID;
            textParams.bottomToBottom = ConstraintSet.PARENT_ID;
            binding.text.setLayoutParams(textParams);

            iconParams.startToStart = ConstraintSet.PARENT_ID;
            iconParams.topToTop = ConstraintSet.PARENT_ID;
            iconParams.bottomToBottom = ConstraintSet.PARENT_ID;
            binding.icon.setLayoutParams(iconParams);


//            constraintSet.clear(R.id.icon,ConstraintSet.LEFT);
//            constraintSet.clear(R.id.icon,ConstraintSet.START);
//            constraintSet.clear(R.id.text,ConstraintSet.LEFT);
//            constraintSet.clear(R.id.text,ConstraintSet.START);
//
//            constraintSet.connect(R.id.icon, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
//
//            constraintSet.connect(R.id.text, ConstraintSet.START, R.id.icon, ConstraintSet.END);
        } else {
            //文案左图标右
//            constraintSet.connect(R.id.text, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
//            constraintSet.connect(R.id.icon, ConstraintSet.START, R.id.text, ConstraintSet.END);
//            constraintSet.applyTo(binding.getRoot());

            textParams.startToStart =  ConstraintSet.PARENT_ID;
            textParams.topToTop = ConstraintSet.PARENT_ID;
            textParams.bottomToBottom = ConstraintSet.PARENT_ID;
            binding.text.setLayoutParams(textParams);

            iconParams.startToEnd = binding.text.getId();
            iconParams.topToTop = ConstraintSet.PARENT_ID;
            iconParams.bottomToBottom = ConstraintSet.PARENT_ID;
            binding.icon.setLayoutParams(iconParams);

        }
//        constraintSet.applyTo(binding.textArrowGroupView);
    }


    public TextView getTextView() {
        return binding.text;
    }


    public AppCompatImageView getIconView() {
        return binding.icon;
    }
}