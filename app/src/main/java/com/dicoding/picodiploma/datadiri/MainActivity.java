package com.dicoding.picodiploma.datadiri;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String STATE_RESULT = "state_result";
    private EditText edt_name, edt_tgl, edt_alamat, edt_notel, edt_hobi, edt_keinginan;
    private Button btn;
    private TextView tvresult;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvresult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edtname);
        edt_tgl = findViewById(R.id.edttgl);
        edt_alamat = findViewById(R.id.edtalamat);
        edt_notel = findViewById(R.id.edtnotel);
        edt_hobi = findViewById(R.id.edthobi);
        edt_keinginan = findViewById(R.id.edtkeinginan);
        btn = findViewById(R.id.button);
        tvresult = findViewById(R.id.tv_result);

        btn.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvresult.setText(result);
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            String inputName = edt_name.getText().toString();
            String inputTgl = edt_tgl.getText().toString();
            String inputAlamat = edt_alamat.getText().toString();
            String inputNotel = edt_notel.getText().toString();
            String inputHobi = edt_hobi.getText().toString();
            String inputKeinginan = edt_keinginan.getText().toString();

            boolean isEmpetyFields = false;

            if (TextUtils.isEmpty(inputName)) {
                isEmpetyFields = true;
                edt_name.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTgl)) {
                isEmpetyFields = true;
                edt_tgl.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputAlamat)) {
                isEmpetyFields = true;
                edt_alamat.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputNotel)) {
                isEmpetyFields = true;
                edt_notel.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHobi)) {
                isEmpetyFields = true;
                edt_hobi.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputKeinginan)) {
                isEmpetyFields = true;
                edt_keinginan.setError("Field ini tidak boleh kosong");
            }


            if (!isEmpetyFields) {
                tvresult.setText("==========\n" + "Informasi tentang\t" + inputName + "\t:" + "\nNama\t:" + inputName + "\nTanggal Lahir\t:" + inputTgl + "\nAlamat\t:" + inputAlamat + "\nNomor Telepon\t:" +
                        inputNotel + "\nHobi\t:" + inputHobi + "\nKeinginan\t:" + inputKeinginan + "\n==========");

            }
        }
    }
}
