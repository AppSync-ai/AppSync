package com.teamup.rohitasawa_library;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.widget.TextView;

public class RohitTextGradient {

    public static void makeShaded(TextView textView, int layersOfGradient) {
        textView.getPaint().setShader(null);
        TextPaint paint = textView.getPaint();
        float width = paint.measureText("" + textView.getText().toString());

        int[] shades = new int[layersOfGradient];
        for (int i = 0; i < layersOfGradient; i++) {
            shades[i] = Color.parseColor(RohitHexColor.generate());
        }

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(), shades, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }
}
