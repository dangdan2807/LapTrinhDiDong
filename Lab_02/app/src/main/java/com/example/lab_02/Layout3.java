package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;

public class Layout3 extends AppCompatActivity implements View.OnClickListener {
    private Button btnGenerator;
    private EditText edtCountWord, edtPassword;
    private CheckBox chkLowerCase, chkUpCase, chkNumber, chkSpecialSymbol;
    private Context context;
    private String arrLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private String arrUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String arrDigit = "0123456789";
    private String arrSpecialSymbol = "!@#$%&*()|;:<>?_+-=";
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private final int MIN_CHARACTERS = 4;
    private final int MAX_CHARACTERS = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        context = this;
        btnGenerator = findViewById(R.id.layout3_btnGenerator);

        edtCountWord = findViewById(R.id.layout3_edtCountWord);
        edtPassword = findViewById(R.id.layout3_edtPassword);

        chkLowerCase = findViewById(R.id.layout3_chkLowerCase);
        chkUpCase = findViewById(R.id.layout3_chkUpCase);
        chkNumber = findViewById(R.id.layout3_chkNumber);
        chkSpecialSymbol = findViewById(R.id.layout3_chkSpecialSymbol);

        edtCountWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String countWordStr = edtCountWord.getText().toString();
                if (countWordStr.isEmpty()) {
                    edtCountWord.setText(MIN_CHARACTERS + "");
                    showMessages("Mật khẩu có tối thiểu là " + MIN_CHARACTERS + " ký tự");
                } else {
                    int countWordInt = Integer.parseInt(countWordStr);
                    if (countWordInt > MAX_CHARACTERS) {
                        edtCountWord.setText(MAX_CHARACTERS + "");
                        showMessages("Mật khẩu có tối đa là " + MAX_CHARACTERS + " ký tự");
                    }
                }
            }
        });

        edtPassword.setOnClickListener(this);
        btnGenerator.setOnClickListener(this);
        chkLowerCase.setOnClickListener(this);
        chkUpCase.setOnClickListener(this);
        chkNumber.setOnClickListener(this);
        chkSpecialSymbol.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(edtPassword)) {
            String data = edtPassword.getText().toString();
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", data);
            clipboard.setPrimaryClip(clip);
            showMessages("Copy to clipboard");
        } else if (o.equals(btnGenerator)) {
            int countWord = Integer.parseInt(edtCountWord.getText().toString());
            boolean isLowerCase = chkLowerCase.isChecked();
            boolean isUpCase = chkUpCase.isChecked();
            boolean isNumberChecked = chkNumber.isChecked();
            boolean isSpecialSymbol = chkSpecialSymbol.isChecked();

            String arrCharacters = "";
            arrCharacters += isLowerCase ? arrLowerCase : "";
            arrCharacters += isUpCase ? arrUpperCase : "";
            arrCharacters += isNumberChecked ? arrDigit : "";
            arrCharacters += isSpecialSymbol ? arrSpecialSymbol : "";

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < countWord; i++) {
                int randomIndex = random.nextInt(arrCharacters.length());
                sb.append(arrCharacters.charAt(randomIndex));
            }
            edtPassword.setText(sb.toString());
        } else if (o.equals(chkLowerCase)) {
            checkChk(chkLowerCase, chkUpCase, chkNumber, chkSpecialSymbol);
        } else if (o.equals(chkUpCase)) {
            checkChk(chkUpCase, chkLowerCase, chkNumber, chkSpecialSymbol);
        } else if (o.equals(chkNumber)) {
            checkChk(chkNumber, chkLowerCase, chkUpCase, chkSpecialSymbol);
        } else if (o.equals(chkSpecialSymbol)) {
            checkChk(chkSpecialSymbol, chkLowerCase, chkUpCase, chkNumber);
        }
    }

    private void checkChk(CheckBox chk1, CheckBox chk2, CheckBox chk3, CheckBox chk4) {
        if (!chk1.isChecked()) {
            if (!chk2.isChecked()) {
                if (!chk3.isChecked())
                    blockFinallyElement(chk4);
                else if (!chk4.isChecked())
                    blockFinallyElement(chk3);
            } else if (!chk3.isChecked()) {
                if (!chk2.isChecked())
                    blockFinallyElement(chk4);
                else if (!chk4.isChecked())
                    blockFinallyElement(chk2);
            } else if (!chk4.isChecked()) {
                if (!chk3.isChecked())
                    blockFinallyElement(chk2);
                else if (!chk2.isChecked())
                    blockFinallyElement(chk3);
            }
        } else if (chk1.isChecked() || chk2.isChecked() || chk3.isChecked() || chk4.isChecked()) {
            setTrueAllCheckBox();
        }
    }

    private void blockFinallyElement(CheckBox chk) {
        chk.setChecked(true);
        chk.setEnabled(false);
    }

    private void setTrueAllCheckBox() {
        chkLowerCase.setEnabled(true);
        chkUpCase.setEnabled(true);
        chkNumber.setEnabled(true);
        chkSpecialSymbol.setEnabled(true);
    }

    private void showMessages(String messages) {
        Toast.makeText(context, messages, Toast.LENGTH_LONG).show();
    }

}