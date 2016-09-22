package brad.tw.guessnumber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private String answer;
    private TextView info;
    private EditText input;
    private int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = (TextView)findViewById(R.id.textInfo);
        input = (EditText)findViewById(R.id.editGuess);

        initGame();
    }

    public void doGuess(View v){
        times++;
        String guess = input.getText().toString();
        String result = checkAB(answer, guess);
        info.append(times + ". " + guess + ":" + result + "\n");
        input.setText("");

        if (result.equals("3A0B")){
            // WINNER
            showDialog(true);
        }else if (times == 10){
            // LOSSER;
            showDialog(false);
        }

    }

    private void showDialog(boolean isWinner){
        AlertDialog alert = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info");
        builder.setMessage(isWinner?"WINNER":"魯蛇一條\n"+answer);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new AlertDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initGame();
            }
        });
        alert = builder.create();
        alert.show();
    }

    private void initGame(){
        times = 0;
        info.setText("");
        answer = createAnswer(3);
    }

    // create a answer
    private String createAnswer(int n){
        HashSet<Integer> set = new HashSet<>();
        while (set.size()<n){
            set.add((int)(Math.random()*10));
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set){
            sb.append(i);
        }
        return sb.toString();
    }
    // check ?A?B
    private String checkAB(String a, String g){
        int A, B; A = B = 0;
        for (int i=0; i<g.length(); i++){
            if (g.charAt(i) == a.charAt(i)){
                A++;
            }else if (a.indexOf(g.charAt(i)) != -1){
                B++;
            }
        }

        return A + "A" + B + "B";
    }

}
