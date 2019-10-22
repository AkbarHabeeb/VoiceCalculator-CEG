package myfirstapp.example.com.voicecalc;

//import android.content.Intent;
//import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;


public class DisplayMessageActivity extends AppCompatActivity
{
    private EditText e1,e2;

    String expr="";
    String s;

    //ScriptEngineManager manager = new ScriptEngineManager();
    //ScriptEngine engine = manager.getEngineByName("nashorn");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);

        e2.setText("");
    }

    public void onClick(View v) throws Exception
    {
        switch(v.getId())
        {
            case R.id.num0: {
                e2.setText(e2.getText()+"0");
                expr = expr + "0";
                break;
            }

            case R.id.num1: {
                e2.setText(e2.getText()+"1");
                expr = expr + "1";
                break;
            }

            case R.id.num2: {
                e2.setText(e2.getText()+"2");
                expr = expr + "2";
                break;
            }

            case R.id.num3: {
                e2.setText(e2.getText()+"3");
                expr = expr + "3";
                break;
            }

            case R.id.num4: {
                e2.setText(e2.getText()+"4");
                expr = expr + "4";
                break;
            }

            case R.id.num5: {
                e2.setText(e2.getText()+"5");
                expr = expr + "5";
                break;
            }

            case R.id.num6: {
                e2.setText(e2.getText()+"6");
                expr = expr + "6";
                break;
            }

            case R.id.num7: {
                e2.setText(e2.getText()+"7");
                expr = expr + "7";
                break;
            }

            case R.id.num8: {
                e2.setText(e2.getText()+"8");
                expr = expr + "8";
                break;
            }

            case R.id.num9: {
                e2.setText(e2.getText()+"9");
                expr = expr + "9";
                break;
            }

            case R.id.dot: 	{
                    e2.setText(e2.getText()+".");
                    expr = expr + ".";
                    break;
            }

            case R.id.clear:    {
                                    e1.setText(expr);
                                    e2.setText("");
                                    expr = "";
                                    break;
                                }

            case R.id.backSpace:
                String boxtext = e2.getText().toString();
                String exprtext = expr;

                if(boxtext.length()>0)
                {
                    if(boxtext.endsWith("sqrt("))
                    {
                        e2.setText(boxtext.substring(0,boxtext.length()-5));
                        expr = exprtext.substring(0,exprtext.length()-5);
                    }
                    else
                    {
                        e2.setText(boxtext.substring(0,boxtext.length()-1));
                        expr = exprtext.substring(0,exprtext.length()-1);
                    }
                }
                break;

            case R.id.plus:		{
                e2.setText(e2.getText()+"+");
                expr = expr + "+";
                break;
            }

            case R.id.minus:	{
                e2.setText(e2.getText()+"-");
                expr = expr + "-";
                break;
            }

            case R.id.divide:	{
                e2.setText(e2.getText()+"/");
                expr = expr + "/";
                break;
            }

            case R.id.multiply:	{
                e2.setText(e2.getText()+"*");
                expr = expr + "*";
                break;
            }

            case R.id.sqrt: {
                e2.setText(e2.getText() + "sqrt(");
                expr = expr + "sqrt(";
                break;
            }

            case R.id.square: {
                e2.setText(e2.getText() + "^");
                //expr = expr + "Math.pow(";
                expr = expr + "^";
                break;
            }

			case R.id.posneg:
                if(e2.length()!=0)
                {
                    String s=e2.getText().toString();
                    char arr[]=s.toCharArray();
                    if(arr[0]=='-')
                        e2.setText(s.substring(1,s.length()));
                    else
                        e2.setText("-"+s);
                }
                break;

            case R.id.equal: {
                try {
                        Expression ex = new Expression(expr);
                        Object ss = ex.calculate();
                        s = ss.toString();

                        e1.setText(s);
                        e2.setText("");
                        expr = "";
                        break;
                } catch (Exception e) {
                    e1.setText("Syntax Error");
                    e2.setText(e.toString());
                    expr = "";
                    break;
                }
            }

            case R.id.openBracket: 	 {
                                        e2.setText(e2.getText()+"(");
                                        expr = expr + "(";
                                        break;
                                    }

            case R.id.closeBracket: {
                                        e2.setText(e2.getText()+")");
                                        expr = expr + ")";
                                        break;
                                    }
        }
    }
}