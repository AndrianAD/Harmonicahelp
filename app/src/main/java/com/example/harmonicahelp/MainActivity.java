package com.example.harmonicahelp;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {

    private Button btnHarm, btnTon, actionCount, btncopy, newactivity;
    public static TextView result;
    public static TextView major;
    public static TextView minor;
    public static TextView blues;
    private static EditText enterTab;
    private static ArrayList noteList2 = new ArrayList();
    private static ArrayList noteList = new ArrayList();
    private static ArrayList tempArray = new ArrayList();
    Note[] note = Note.values;
    public static int n = 5;
    public static int z = 0;
    static int octava_set = 0;
    static String rezultat = " ";
    static String gammaview = " ";
    public static List<String> list = new ArrayList<String>();
    public static Hole final_tabs;
    static int temp;
    CustomKeyboard mCustomKeyboard;
    ClipboardManager clipboardManager;
    ClipData clipData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

        mCustomKeyboard = new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd);
        mCustomKeyboard.registerEditText(R.id.edit_text_enter_tabl);
        Button reset = (Button) findViewById(R.id.reset_id);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


        btncopy = (Button) findViewById(R.id.button_copy);
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        btncopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = enterTab.getText().toString();
                clipData = ClipData.newPlainText("text", text);
                clipboardManager.setPrimaryClip(clipData);
                Toast toast = Toast.makeText(getApplicationContext(), "Text Copied", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        newactivity = (Button) findViewById(R.id.button);
        newactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercice.class);
                startActivity(intent);
            }
        });







// Чекбокс мажор
        CheckBox switchCheckBox_major = (CheckBox) findViewById(R.id.switch_check_box_major);
        switchCheckBox_major.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                getGamma_major(isChecked);
            }
        });

// Чекбокс мінор
        CheckBox switchCheckBox_minor = (CheckBox) findViewById(R.id.switch_check_box_minor);
        switchCheckBox_minor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                getGamma_minor(isChecked);
            }
        });

// Чекбокс блюз
        CheckBox switchCheckBox_blues = (CheckBox) findViewById(R.id.switch_check_box_blues);
        switchCheckBox_blues.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                getGamma_blues(isChecked);
            }
        });

// Кнопка "Посчитать"
        actionCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                сalculate();
            }
        });

// Make noteList
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
// Make noteList2
        btnTon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makelist2(z_view);
            }
        });


        Button octava_plus = (Button) findViewById(R.id.octava_plus);
        final Button octava_minus = (Button) findViewById(R.id.octava_minus);

        octava_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int min = (int) Collections.min(tempArray);
                    if (octava_set >= 25) {
                        return;
                    }
                    if (min >= 12) {
                        octava_set = octava_set + 12;
                        changetabs();
                    } else
                        return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        octava_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int max = (int) Collections.max(tempArray);
                    if (max <= 25) {
                        octava_set = octava_set + (-12);
                        changetabs();
                    } else
                        return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public static void сalculate() {
        try {
            if (noteList.isEmpty() || noteList2.isEmpty()) {
                return;
            }
            String get_tab = (enterTab.getText().toString());
            octava_set = 0;
            input_tabs(get_tab);
            changetabs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makelist2(final TextView z_view) {
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
    //---------------------


    @Override
    public void onBackPressed() {
        // NOTE Trap the back key: when the CustomKeyboard is still visible hide it, only when it is invisible, finish activity
        if (mCustomKeyboard.isCustomKeyboardVisible()) mCustomKeyboard.hideCustomKeyboard();
        else this.finish();
    }

    public void tonalinosti() {
        for (int i = n; i < 37 + n + 1; i++) {
            Hole hole = new Hole(note[i], note[i - n]);
            noteList.add(hole);
        }
        temp = check_temp(n, z);
    }

    public void tonalinosti2() {
        for (int i = z; i < 37 + z + 1; i++) {
            Hole hole = new Hole(note[i], note[i - z]);
            noteList2.add(hole);
        }
        temp = check_temp(n, z);
        getGamma_major(false);
        getGamma_minor(false);
        getGamma_blues(false);
    }


    public void getGamma_major(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {2, 2, 1, 2, 2, 2, 1};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        major.setText(gammaview);
        gammaview = "";
    }
    public void getGamma_minor(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {2, 1, 2, 2, 1, 2, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        minor.setText(gammaview);
        gammaview = "";
    }
    public void getGamma_blues(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {3, 2, 1, 1, 3, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 6) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        blues.setText(gammaview);
        gammaview = "";
    }

    private int check_temp(int n, int z) {
        int temp = z - n;
        int[] nums = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11};
        for (int i : nums) {
            if (temp == i) {
                temp = 12 - (-i);
                break;
            }
        }
        return temp;
    }

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

    // код смены табов
    public static void changetabs() {
        try {
            tempArray.clear();
            rezultat = "";
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < 38; j++) {
                    Hole hole = (Hole) noteList2.get(j);
                    String list_i = list.get(i);
                    String list_J = hole.getTabs();
                    // Ищет совпадения в первом List
                    if (list_J.equals(list_i)) {
                        int peremennaia = j + temp;
                        if (peremennaia < 0) {
                            peremennaia = peremennaia + 12;
                        }
                        if (peremennaia > 37) {
                            peremennaia = peremennaia - 12;
                        }
                        tempArray.add(peremennaia - octava_set);
                        final_tabs = (Hole) noteList.get(peremennaia - octava_set);
                        rezultat += " " + final_tabs.getTabs();
                        break;
                    }
                }
            }
            result.setText(rezultat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
