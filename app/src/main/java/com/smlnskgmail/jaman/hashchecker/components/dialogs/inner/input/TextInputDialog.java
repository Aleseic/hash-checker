package com.smlnskgmail.jaman.hashchecker.components.dialogs.inner.input;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.EditText;

import com.smlnskgmail.jaman.hashchecker.R;
import com.smlnskgmail.jaman.hashchecker.components.dialogs.inner.BaseDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class TextInputDialog extends BaseDialog {

    @BindView(R.id.et_dialog_input_text)
    protected EditText fieldTextValue;

    private OnTextValueEnteredListener textValueCallback;

    private String textValue;

    public TextInputDialog(@NonNull Context context,
                           @NonNull OnTextValueEnteredListener textEnteredCallback,
                           @Nullable String textValue) {
        super(context);
        this.textValueCallback = textEnteredCallback;
        this.textValue = textValue;
    }

    @OnClick(R.id.btn_dialog_input_text_add)
    void addText() {
        textValueCallback.onTextValueEntered(fieldTextValue.getText().toString());
        dismiss();
    }

    @Override
    public void initUI() {
        fieldTextValue.requestFocus();
        if (textValue == null) {
            fieldTextValue.setText("");
        } else {
            fieldTextValue.setText(textValue);
            fieldTextValue.setSelection(textValue.length());
        }
    }
    @Override
    public void setupDialogStyle() {
        super.setupDialogStyle();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.dialog_text_input;
    }

}
