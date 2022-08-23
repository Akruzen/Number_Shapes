package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static class Number
    {
        int number;

        public boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean isTriangular()
        {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number)
            {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public void check(View view)
    {
        Log.i("Info", "Button Pressed!");

        EditText editText = (EditText) findViewById(R.id.editTextNumber);

        String message = editText.getText().toString();

        if (editText.getText().toString().isEmpty())
        {
            message = message + "Enter a number!!";
        }
        else if (Integer.parseInt(editText.getText().toString()) < 0)
        {
            message = message + "Enter a positive number!!";
        }
        else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message = message + " is square and triangular!!";
            } else if (myNumber.isSquare()) {
                message = message + " is square!!";
            } else if (myNumber.isTriangular()) {
                message = message + " is triangular";
            } else {
                message = message + " is neither square nor triangular";
            }

        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        //System.out.println(myNumber.isSquare());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}