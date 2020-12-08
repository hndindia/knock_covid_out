package com.chhattisgarh.sora_11.Module;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import static com.chhattisgarh.sora_11.Module.BecomeVolunteer.setEndDate;


public class DatePickerFragmentEndDate extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                this,
                1904,month,day);


        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis()-1000);
        datePickerDialog.getDatePicker().findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        return datePickerDialog;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


            setEndDate(year,month + 1, dayOfMonth);

    }

}
