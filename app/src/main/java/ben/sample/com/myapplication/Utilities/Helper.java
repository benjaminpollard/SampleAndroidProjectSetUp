package ben.sample.com.myapplication.Utilities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;

public class Helper {
    public static int getScreenHeight(Activity context) {
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int ScreenHeight = metrics.heightPixels;
        return ScreenHeight;
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null) {
            View focusedview = activity.getCurrentFocus();
            if (focusedview != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(focusedview.getWindowToken(), 0);
                }
            }
        }
    }

    public static void generalMessage(View layout, String msg) {
        Snackbar.make(layout, msg, Snackbar.LENGTH_LONG)
                .show();
    }

    public static void generalMessage(View layout, String msg, int durationMillis) {
        Snackbar.make(layout, msg, durationMillis)
                .show();
    }

    public static void generalMessage(View layout, String msg, String retryButtonText,View.OnClickListener retryListener) {
        Snackbar.make(layout, msg, Snackbar.LENGTH_LONG)
                .setAction(retryButtonText, retryListener)
                .show();
    }

    public static void animateFadeOut(View v, int duration){
        ObjectAnimator fadeOutAnim = ObjectAnimator.ofFloat(v, "alpha", 1, 0);
        fadeOutAnim.setInterpolator(new AccelerateInterpolator());
        fadeOutAnim.setDuration(duration);
        fadeOutAnim.start();
    }

    public static void animateFadeIn(View v, int duration){
        ObjectAnimator fadeOutAnim = ObjectAnimator.ofFloat(v, "alpha", 0, 1);
        fadeOutAnim.setInterpolator(new DecelerateInterpolator());
        fadeOutAnim.setDuration(duration);
        fadeOutAnim.start();
    }

    public static void showDialog(Context context, String title, String Message, String postativeButton , DialogInterface.OnClickListener onClickListenerPostive , String negativeButton, DialogInterface.OnClickListener onClickListenerNegative )
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        if(title != null && !title.isEmpty())
        {
            alertDialogBuilder.setTitle(title);
        }

        if(Message != null && !Message.isEmpty())
        {
            alertDialogBuilder.setMessage(Message);
        }

        if(postativeButton != null && !postativeButton.isEmpty() && onClickListenerPostive != null)
        {
            alertDialogBuilder.setPositiveButton(postativeButton,onClickListenerPostive);
        }

        if(negativeButton != null && !negativeButton.isEmpty() && onClickListenerNegative != null)
        {
            alertDialogBuilder.setPositiveButton(negativeButton,onClickListenerNegative);
        }

        alertDialogBuilder.show();
    }
}
