package id.sch.smktelkom_mlg.tugas01.xiirpl1011.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNama, editTextAlamat;
    Button buttonOk;
    TextView TextViewTitle, TextViewjk, tvhasil;
    RadioGroup rgjk;
    Spinner spinnerProv;
    CheckBox checkbox1, checkBox2, checkBox3, checkBox4, checkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        buttonOk = (Button) findViewById(R.id.buttonOk);

        TextViewTitle = (TextView) findViewById(R.id.TextViewTitle);
        TextViewjk = (TextView) findViewById(R.id.textViewjk);
        tvhasil = (TextView) findViewById(R.id.tvhasil);
        rgjk = (RadioGroup) findViewById(R.id.rgjk);
        spinnerProv = (Spinner) findViewById(R.id.spinnerProv);

        checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProses();
            }
        });
    }

    private void doProses() {
        if (isValid()) {
            String nama = editTextNama.getText().toString();
            String alamat = editTextAlamat.getText().toString();
            String hasil = null;

            if (rgjk.getCheckedRadioButtonId() != -1) {
                RadioButton RadioButtonFe = (RadioButton) findViewById(rgjk.getCheckedRadioButtonId());
                hasil = RadioButtonFe.getText().toString();
            }
            if (hasil == null) {
                tvhasil.setText("Belum memilih jenis kelamin");
            } else {
                String provinsi = spinnerProv.getSelectedItem().toString();
                String hasil1 = "Jenis obat yang anda pilih : \n";
                String akhir = "Nama : " + nama + "\n"
                        + "Alamat : " + alamat + "\n"
                        + "Anda bertempat tinggal di provisi :" + provinsi + "\n"
                        + "Jenis kelamin :" + hasil;

                if (checkbox1.isChecked())
                    hasil1 += checkbox1.getText() + "\n";
                tvhasil.setText(akhir + hasil1);

                if (checkBox2.isChecked())
                    hasil1 += checkBox2.getText() + "\n";
                tvhasil.setText(akhir + hasil1);

                if (checkBox3.isChecked())
                    hasil1 += checkBox3.getText() + "\n";
                tvhasil.setText(akhir + hasil1);

                if (checkBox4.isChecked())
                    hasil1 += checkBox4.getText() + "\n";
                tvhasil.setText(akhir + hasil1);

                if (checkBox5.isChecked())
                    hasil1 += checkBox5.getText() + "\n";
                tvhasil.setText(akhir + hasil1);

            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = editTextNama.getText().toString();
        String alamat = editTextAlamat.getText().toString();

        if (nama.isEmpty()) {
            editTextNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() > 25) {
            editTextNama.setError("Nama maksimal 25 karakter");
            valid = false;
        } else {
            editTextNama.setError(null);
        }

        if (alamat.isEmpty()) {
            editTextAlamat.setError("Alamat belum diisi");
            valid = false;
        } else if (alamat.length() > 30) {
            editTextAlamat.setError("Alamat maksimal 30 karakter");
            valid = false;
        } else {
            editTextAlamat.setError(null);
        }
        return valid;
    }

}
