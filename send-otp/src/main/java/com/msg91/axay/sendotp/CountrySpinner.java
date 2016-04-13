package com.msg91.axay.sendotp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author akshay
 * @since 13/4/16
 */
public class CountrySpinner extends Spinner {

    private Map<String, String> mCountries = new TreeMap<>();
    private List<CountryIsoSelectedListener> mListeners = new ArrayList<>();

    public interface CountryIsoSelectedListener {
        void onCountryIsoSelected(String iso);
    }

    public CountrySpinner(Context context) {
        super(context);
    }

    public CountrySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(String defaultCountry) {
        initCountries();
        List<String> countryList = new ArrayList<>();

        countryList.addAll(mCountries.keySet());
        countryList.remove(defaultCountry);
        countryList.add(0, defaultCountry);

        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, countryList);

        setAdapter(adapter);

        setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                final String selectedCountry = (String) adapterView.getItemAtPosition(position);
                notifyListeners(selectedCountry);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void addCountryIsoSelectedListener(CountryIsoSelectedListener listener) {
        mListeners.add(listener);
    }

    public void removeCountryIsoSelectedListener(CountryIsoSelectedListener listener) {
        mListeners.remove(listener);
    }

    private void initCountries() {
        String[] isoCountryCodes = Locale.getISOCountries();
        for (String iso : isoCountryCodes) {
            String country = new Locale("", iso).getDisplayCountry();
            mCountries.put(country, iso);
        }
    }

    private void notifyListeners(String selectedCountry) {
        final String selectedIso = mCountries.get(selectedCountry);
        for (CountryIsoSelectedListener listener : mListeners) {
            listener.onCountryIsoSelected(selectedIso);
        }
    }
}

