package com.example.harmonicahelp;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button btnHarm;
    private Button btnTon;
    private EditText enterTab;
    private Button actionCount;
    public static TextView result;
    public static TextView major;
    public static TextView minor;
    public static TextView blues;
    public static ArrayList noteList2 = new ArrayList();
    public static ArrayList noteList = new ArrayList();
    Note[] note = Note.values;
    public static int n = 0;
    public static int z = 0;
    static String rezultat = " ";
    static String gammaview = " ";
    public static List<String> list = new ArrayList<String>();
    public static Dirka final_tabs;
    public static ArrayList gamma = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHarm = (Button) findViewById(R.id.button_my_harm_key);
        btnTon = (Button) findViewById(R.id.button_ton_id);
        enterTab = (EditText) findViewById(R.id.edit_text_enter_tabl);
        actionCount = (Button) findViewById(R.id.button_action_count);
        result = (TextView) findViewById(R.id.text_view_result);
        major = (TextView) findViewById(R.id.gamma_major);
        minor = (TextView) findViewById(R.id.gamma_minor);
        blues = (TextView) findViewById(R.id.gamma_blues);

        final TextView n_view = (TextView) findViewById(R.id.view_n);
        final TextView z_view = (TextView) findViewById(R.id.view_z);

// Чекбокс мажор
        CheckBox switchCheckBox_major = (CheckBox) findViewById(R.id.switch_check_box_major);
        switchCheckBox_major.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList.isEmpty() || noteList2.isEmpty()) {
                    return;
                }
                getGamma_major(isChecked);
            }
        });

// Чекбокс мінор
        CheckBox switchCheckBox_minor = (CheckBox) findViewById(R.id.switch_check_box_minor);
        switchCheckBox_minor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList.isEmpty() || noteList2.isEmpty()) {
                    return;
                }
                getGamma_minor(isChecked);
            }
        });

// Чекбокс блюз
        CheckBox switchCheckBox_blues = (CheckBox) findViewById(R.id.switch_check_box_blues);
        switchCheckBox_blues.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList.isEmpty() || noteList2.isEmpty()) {
                    return;
                }
                getGamma_blues(isChecked);
            }
        });

// Кнопка "Посчитать"
        actionCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noteList.isEmpty() || noteList2.isEmpty()) {
                    return;
                }
                String get_tab = (enterTab.getText().toString());
                input_tabs(get_tab);
                changetabs();


            }
        });


        btnHarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.button_key);
                dialog.show();
                final Button button0 = (Button) dialog.findViewById(R.id.button0);
                final Button button1 = (Button) dialog.findViewById(R.id.button1);
                final Button button2 = (Button) dialog.findViewById(R.id.button2);
                final Button button3 = (Button) dialog.findViewById(R.id.button3);
                final Button button4 = (Button) dialog.findViewById(R.id.button4);
                final Button button5 = (Button) dialog.findViewById(R.id.button5);
                final Button button6 = (Button) dialog.findViewById(R.id.button6);
                final Button button7 = (Button) dialog.findViewById(R.id.button7);
                final Button button8 = (Button) dialog.findViewById(R.id.button8);
                final Button button9 = (Button) dialog.findViewById(R.id.button9);
                final Button button10 = (Button) dialog.findViewById(R.id.button10);
                final Button button11 = (Button) dialog.findViewById(R.id.button11);
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.button0:
                                n = 0;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button0.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button1:
                                n = 1;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button1.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button2:
                                n = 2;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button2.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button3:
                                n = 3;
                                noteList.clear();
                                tonalinosti();
                                dialog.dismiss();
                                n_view.setText(button3.getText());
                                break;

                            case R.id.button4:
                                n = 4;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button4.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button5:
                                n = 5;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button5.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button6:
                                n = 6;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button6.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button7:
                                n = 7;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button7.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button8:
                                n = 8;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button8.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button9:
                                n = 9;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button9.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button10:
                                n = 10;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button10.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button11:
                                n = 11;
                                noteList.clear();
                                tonalinosti();
                                n_view.setText(button11.getText());
                                dialog.dismiss();
                                break;
                            default:
                                result.setText("WRONG!");
                                dialog.dismiss();


                        }
                    }
                };
                button0.setOnClickListener(onClickListener);
                button1.setOnClickListener(onClickListener);
                button2.setOnClickListener(onClickListener);
                button3.setOnClickListener(onClickListener);
                button4.setOnClickListener(onClickListener);
                button5.setOnClickListener(onClickListener);
                button6.setOnClickListener(onClickListener);
                button7.setOnClickListener(onClickListener);
                button8.setOnClickListener(onClickListener);
                button9.setOnClickListener(onClickListener);
                button10.setOnClickListener(onClickListener);
                button11.setOnClickListener(onClickListener);

            }
        });

        btnTon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.button_key);
                dialog.show();
                final Button button0 = (Button) dialog.findViewById(R.id.button0);
                final Button button1 = (Button) dialog.findViewById(R.id.button1);
                final Button button2 = (Button) dialog.findViewById(R.id.button2);
                final Button button3 = (Button) dialog.findViewById(R.id.button3);
                final Button button4 = (Button) dialog.findViewById(R.id.button4);
                final Button button5 = (Button) dialog.findViewById(R.id.button5);
                final Button button6 = (Button) dialog.findViewById(R.id.button6);
                final Button button7 = (Button) dialog.findViewById(R.id.button7);
                final Button button8 = (Button) dialog.findViewById(R.id.button8);
                final Button button9 = (Button) dialog.findViewById(R.id.button9);
                final Button button10 = (Button) dialog.findViewById(R.id.button10);
                final Button button11 = (Button) dialog.findViewById(R.id.button11);
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.button0:
                                z = 0;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button0.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button1:
                                z = 1;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button1.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button2:
                                z = 2;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button2.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button3:
                                z = 3;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button3.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button4:
                                z = 4;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button4.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button5:
                                z = 5;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button5.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button6:
                                z = 6;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button6.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button7:
                                z = 7;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button7.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button8:
                                z = 8;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button8.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button9:
                                z = 9;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button9.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button10:
                                z = 10;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button10.getText());
                                dialog.dismiss();
                                break;

                            case R.id.button11:
                                z = 11;
                                noteList2.clear();
                                tonalinosti2();
                                z_view.setText(button11.getText());
                                dialog.dismiss();
                                break;
                            default:
                                result.setText("WRONG!");
                                dialog.dismiss();


                        }
                    }
                };
                button0.setOnClickListener(onClickListener);
                button1.setOnClickListener(onClickListener);
                button2.setOnClickListener(onClickListener);
                button3.setOnClickListener(onClickListener);
                button4.setOnClickListener(onClickListener);
                button5.setOnClickListener(onClickListener);
                button6.setOnClickListener(onClickListener);
                button7.setOnClickListener(onClickListener);
                button8.setOnClickListener(onClickListener);
                button9.setOnClickListener(onClickListener);
                button10.setOnClickListener(onClickListener);
                button11.setOnClickListener(onClickListener);

            }
        });}


    public void tonalinosti() {
        for (int i = n; i < 37 + n + 1; i++) {
            Dirka dirka = new Dirka(note[i], note[i - n]);
            noteList.add(dirka);
        }
    }

    public void tonalinosti2() {
        for (int i = z; i < 37 + z + 1; i++) {
            Dirka dirka = new Dirka(note[i], note[i - z]);
            noteList2.add(dirka);
        }
    }


//    public static void getGammaposition() {
//        gamma.clear();
//        int count1=0,count2=0;
//        int iterator=0;
//        for (int i = 0; i <37; i=i+iterator) {
//            Dirka dirka2 = (Dirka) noteList.get(i);
//            gammaview+=" "+dirka2.getNote();
//            count1++;
//            count2++;
//            iterator=2;
//            if( count1==3 && count2==3){
//                count1=0;
//                iterator=1;
//            }
//            if(count2==7){
//                count2=0;
//                count1=0;
//                iterator=1;
//            }
//        }
//        gamma_rezult.setText(gammaview);
//        gammaview="";
//    }

    public void getGamma_major(boolean isChecked) {
        gamma.clear();
        int j = 0;
        int int_masiv = 0;
        int temp = z - n;
        if (temp == -5) {
            temp = 7;
        }
        if (temp == -4) {
            temp = 8;
        }
        if (temp == -3) {
            temp = 9;
        }
        if (temp == -2) {
            temp = 10;
        }
        if (temp == -1) {
            temp = 11;
        }
        if (temp == 0) {
            temp = z + 7;
        }
        final int[] masiv = {2, 2, 1, 2, 2, 2, 1};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Dirka dirka= new Dirka(note[i],note[i+temp]);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? dirka.getNote() + " " : dirka.getTabs() + " ";
        }
        major.setText(gammaview);
        gammaview = "";
    }


    public void getGamma_minor(boolean isChecked) {
        gamma.clear();
        int j = 0;
        int int_masiv = 0;
        int temp = z - n;
        if (temp == -5) {
            temp = 7;
        }
        if (temp == -4) {
            temp = 8;
        }
        if (temp == -3) {
            temp = 9;
        }
        if (temp == -2) {
            temp = 10;
        }
        if (temp == -1) {
            temp = 11;
        }
        if (temp == 0) {
            temp = z + 7;
        }
        final int[] masiv = {2, 1, 2, 2, 1, 2, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Dirka dirka= new Dirka(note[i],note[i+temp]);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? dirka.getNote() + " " : dirka.getTabs() + " ";
        }
        minor.setText(gammaview);
        gammaview = "";
    }

    public void getGamma_blues(boolean isChecked) {
        gamma.clear();
        int j = 0;
        int int_masiv = 0;
        int temp = z - n;
        if (temp == -5) {
            temp = 7;
        }
        if (temp == -4) {
            temp = 8;
        }
        if (temp == -3) {
            temp = 9;
        }
        if (temp == -2) {
            temp = 10;
        }
        if (temp == -1) {
            temp = 11;
        }
        if (temp == 0) {
            temp = z + 7;
        }
        final int[] masiv = {3, 2, 1, 1, 3, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Dirka dirka= new Dirka(note[i],note[i+temp]);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? dirka.getNote() + " " : dirka.getTabs() + " ";
        }
        blues.setText(gammaview);
        gammaview = "";
    }


//
//    public static void getGamma_major() {
//        gamma.clear();
//        int j = 0;
//        int int_masiv = 0;
//        final int[] masiv = {2, 2, 1, 2, 2, 2, 1};
//        for (int i = 0; i < 37; i = i + int_masiv) {
//            int_masiv = masiv[j];
//            Dirka dirka2 = (Dirka) noteList.get(i);
//            j++;
//            if (j == 7) {
//                j = 0;
//            }
//            gammaview += " " + dirka2.getNote();
//        }
//        major.setText(gammaview);
//        gammaview = "";
//    }


    // Ввод исходных табов от пользователя
    public static void input_tabs(String inputtabs) {
        String str[] = inputtabs.split(" ");
        int i = 0;
        do {
            if (str[i].equals("3")) {
                str[i] = "-2";

            }
            i++;
        }
        while (i != str.length);


        list = Arrays.asList(str);
    }


    public static void changetabs() {
        int k = 0;
        rezultat = "";
        for (int i = 0; i < list.size(); i++) {
            k = 0;
            for (int j = 0; j < 38; j++) {
                Dirka dirka = (Dirka) noteList2.get(j);
                k++;
                String list_i = list.get(i);
                String list_J = dirka.getTabs();
                // Ищет совпадения в первом List
                if (list_J.equals(list_i)) {
                    int peremennaia = k + z - n - 1;
                    if (peremennaia < 0) {
                        peremennaia = peremennaia + n + 7;
                    }
                    if (peremennaia > 37) {
                        peremennaia = peremennaia - n - 7;
                    }
                    final_tabs = (Dirka) noteList.get(peremennaia);
                    rezultat += " " + final_tabs.getTabs();
                    break;
                }
            }
        }
        result.setText(rezultat);
    }


}


