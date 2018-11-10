package com.example.astrid.resistance6;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Astrid on 04/02/2016.
 */
public class ResistanceCouleurFragment extends Fragment {
    Spinner Tolerance, Coefficient, NbAnneaux;
    EditText Resistance;
    int PremierNb;
    int DeuxiemeNb;
    int TroisiemeNb;
    float MultiplicateurNb;
    String multiplicateur;
    String tolerance;
    String coefficient;
    float resultat;
    String resultatrecalcul;
    Resources res;
    int [] colorsValue1, colorsValue, colorsMultiplicateur, colorsTolerance, colorsCoefficient;
    String [] txtvaleur, txtvaleur1;
    int [] tabvaleur, tabvaleur1;
    String [] txtmultiplicateur, tabmultiplicateur, txttolerance, tabtolerance, tabnbanneaux, tabcoefficient;
    Button btnValue1, btnValue2, btnValue3, btnMultiplicateur, btnTolerance, btnCoefficient, btnOk;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.resistance_couleur, container, false);

        res=getResources();
        txtvaleur=res.getStringArray(R.array.Valeur);
        txtvaleur1=res.getStringArray(R.array.Value);
        tabvaleur1=res.getIntArray(R.array.Value2);
        tabvaleur= res.getIntArray(R.array.Valeur2);
        txtmultiplicateur = res.getStringArray(R.array.Multiplicateur);
        tabmultiplicateur = res.getStringArray(R.array.Multiplicateur2);
        txttolerance = res.getStringArray(R.array.Tolérance);
        tabtolerance = res.getStringArray(R.array.Tolérance2);
        tabnbanneaux = res.getStringArray(R.array.NbAnneaux);
        tabcoefficient = res.getStringArray(R.array.Coefficient2);

        colorsValue1 = new int [tabvaleur1.length];
        colorsValue1[0] = res.getColor(R.color.marron);
        colorsValue1[1] = res.getColor(R.color.rouge);
        colorsValue1[2] = res.getColor(R.color.orange);
        colorsValue1[3] = res.getColor(R.color.jaune);
        colorsValue1[4] = res.getColor(R.color.vert);
        colorsValue1[5] = res.getColor(R.color.bleu);
        colorsValue1[6] = res.getColor(R.color.violet);
        colorsValue1[7] = res.getColor(R.color.gris);
        colorsValue1[8] = res.getColor(R.color.blanc);

        colorsValue = new int [tabvaleur.length];
        colorsValue[0] = res.getColor(R.color.noir);
        colorsValue[1] = res.getColor(R.color.marron);
        colorsValue[2] = res.getColor(R.color.rouge);
        colorsValue[3] = res.getColor(R.color.orange);
        colorsValue[4] = res.getColor(R.color.jaune);
        colorsValue[5] = res.getColor(R.color.vert);
        colorsValue[6] = res.getColor(R.color.bleu);
        colorsValue[7] = res.getColor(R.color.violet);
        colorsValue[8] = res.getColor(R.color.gris);
        colorsValue[9] = res.getColor(R.color.blanc);

        colorsMultiplicateur = new int [tabmultiplicateur.length];
        colorsMultiplicateur[0] = res.getColor(R.color.noir);
        colorsMultiplicateur[1] = res.getColor(R.color.marron);
        colorsMultiplicateur[2] = res.getColor(R.color.rouge);
        colorsMultiplicateur[3] = res.getColor(R.color.orange);
        colorsMultiplicateur[4] = res.getColor(R.color.jaune);
        colorsMultiplicateur[5] = res.getColor(R.color.vert);
        colorsMultiplicateur[6] = res.getColor(R.color.bleu);
        colorsMultiplicateur[7] = res.getColor(R.color.violet);
        colorsMultiplicateur[8] = res.getColor(R.color.gris);
        colorsMultiplicateur[9] = res.getColor(R.color.blanc);
        colorsMultiplicateur[10] = res.getColor(R.color.or);
        colorsMultiplicateur[11] = res.getColor(R.color.argent);

        colorsTolerance = new int [tabtolerance.length];
        colorsTolerance[0] = res.getColor(R.color.marron);
        colorsTolerance[1] = res.getColor(R.color.rouge);
        colorsTolerance[2] = res.getColor(R.color.vert);
        colorsTolerance[3] = res.getColor(R.color.bleu);
        colorsTolerance[4] = res.getColor(R.color.violet);
        colorsTolerance[5] = res.getColor(R.color.gris);
        colorsTolerance[6] = res.getColor(R.color.or);
        colorsTolerance[7] = res.getColor(R.color.argent);

        colorsCoefficient = new int [tabcoefficient.length];
        colorsCoefficient[0] = res.getColor(R.color.marron);
        colorsCoefficient[1] = res.getColor(R.color.rouge);
        colorsCoefficient[2] = res.getColor(R.color.orange);
        colorsCoefficient[3] = res.getColor(R.color.jaune);
        colorsCoefficient[4] = res.getColor(R.color.bleu);
        colorsCoefficient[5] = res.getColor(R.color.violet);
        colorsCoefficient[6] = res.getColor(R.color.blanc);

        NbAnneaux=rootView.findViewById(R.id.spinnerNbAnneaux);
        Tolerance=rootView.findViewById(R.id.spinnerTolerance);
        Coefficient=rootView.findViewById(R.id.spinnerCoefficient);
        Resistance=rootView.findViewById(R.id.resistance);
        btnValue1=rootView.findViewById(R.id.btnValue1);
        btnValue2=rootView.findViewById(R.id.btnValue2);
        btnValue3=rootView.findViewById(R.id.btnValue3);
        btnMultiplicateur=rootView.findViewById(R.id.btnMultiplicateur);
        btnTolerance=rootView.findViewById(R.id.btnTolerance);
        btnCoefficient=rootView.findViewById(R.id.btnCoefficient);
        btnOk=rootView.findViewById(R.id.btnOk);
        Resistance=rootView.findViewById(R.id.resistance);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    resultat = Float.parseFloat(Resistance.getText().toString());
                            if (tabnbanneaux[0].equals(NbAnneaux.getSelectedItem().toString()) || tabnbanneaux[1].equals(NbAnneaux.getSelectedItem().toString())) {
                                if (resultat >= 10) {
                                    resultatrecalcul = String.valueOf(resultat);
                                    MultiplicateurNb = (Integer.valueOf("10" + Resistance.getText().toString().substring(2))) / 10;
                                } else if (resultat >= 1) {
                                    resultatrecalcul = String.valueOf(resultat * 10);
                                    MultiplicateurNb = Float.parseFloat("0.1");
                                } else {
                                    resultatrecalcul = String.valueOf(resultat * 100);
                                    MultiplicateurNb = Float.parseFloat("0.01");
                                }
                            } else if (tabnbanneaux[2].equals(NbAnneaux.getSelectedItem().toString()) || tabnbanneaux[3].equals(NbAnneaux.getSelectedItem().toString())) {
                                if (resultat >= 100) {
                                    resultatrecalcul = String.valueOf(resultat);
                                    MultiplicateurNb = (Integer.valueOf("10" + Resistance.getText().toString().substring(3))) / 10;
                                } else if (resultat >= 10) {
                                    resultatrecalcul = String.valueOf(resultat * 10);
                                    MultiplicateurNb = Float.parseFloat("0.1");
                                } else {
                                    resultatrecalcul = String.valueOf(resultat * 100);
                                    MultiplicateurNb = Float.parseFloat("0.01");
                                }
                                TroisiemeNb = Integer.valueOf(resultatrecalcul.substring(2, 3));
                                for (int i = 0; i < tabvaleur.length; i++) {
                                    if (TroisiemeNb == tabvaleur[i]) {
                                        btnValue3.setBackgroundColor(colorsValue[i]);
                                    }
                                }
                            }
                            PremierNb = Integer.valueOf(resultatrecalcul.substring(0, 1));
                            DeuxiemeNb = Integer.valueOf(resultatrecalcul.substring(1, 2));
                            for (int i = 0; i < tabvaleur1.length; i++) {
                                if (PremierNb == tabvaleur1[i]) {
                                    btnValue1.setBackgroundColor(colorsValue1[i]);
                                }
                            }
                            for (int i = 0; i < tabvaleur.length; i++) {
                                if (DeuxiemeNb == tabvaleur[i]) {
                                    btnValue2.setBackgroundColor(colorsValue[i]);
                                }
                            }
                            for (int i = 0; i < tabmultiplicateur.length; i++) {
                                if (MultiplicateurNb == Float.parseFloat(tabmultiplicateur[i])) {
                                    btnMultiplicateur.setBackgroundColor(colorsMultiplicateur[i]);
                                }
                            }

                    if (tabnbanneaux[1].equals(NbAnneaux.getSelectedItem().toString()) || tabnbanneaux[2].equals(NbAnneaux.getSelectedItem().toString()) ||
                            tabnbanneaux[3].equals(NbAnneaux.getSelectedItem().toString())) {
                        tolerance = Tolerance.getSelectedItem().toString();
                        System.out.println(tolerance);
                        for (int i = 0; i < tabtolerance.length; i++) {
                            if (tolerance.equals(tabtolerance[i])) {
                                btnTolerance.setBackgroundColor(colorsTolerance[i]);
                            }
                        }
                    }
                    if (tabnbanneaux[3].equals(NbAnneaux.getSelectedItem().toString())) {
                        coefficient = Coefficient.getSelectedItem().toString();
                        System.out.println(coefficient);
                        for (int i = 0; i < tabcoefficient.length; i++) {
                            if (coefficient.equals(tabcoefficient[i])) {
                                btnCoefficient.setBackgroundColor(colorsCoefficient[i]);
                            }
                        }
                    } } catch(Exception e){
                            Toast.makeText(getContext(), "Cette résistance ne peut pas être calculée.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        NbAnneaux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(tabnbanneaux[0].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    btnValue3.setVisibility(View.INVISIBLE);
                    btnTolerance.setVisibility(View.INVISIBLE);
                    btnCoefficient.setVisibility(View.INVISIBLE);
                    Tolerance.setVisibility(View.INVISIBLE);
                    Coefficient.setVisibility(View.INVISIBLE);
                }
                if(tabnbanneaux[1].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    btnValue3.setVisibility(View.INVISIBLE);
                    btnTolerance.setVisibility(View.VISIBLE);
                    btnCoefficient.setVisibility(View.INVISIBLE);
                    Tolerance.setVisibility(View.VISIBLE);
                    Coefficient.setVisibility(View.INVISIBLE);
                }
                if(tabnbanneaux[2].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    btnValue3.setVisibility(View.VISIBLE);
                    btnTolerance.setVisibility(View.VISIBLE);
                    btnCoefficient.setVisibility(View.INVISIBLE);
                    Tolerance.setVisibility(View.VISIBLE);
                    Coefficient.setVisibility(View.INVISIBLE);
                }
                if(tabnbanneaux[3].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    btnValue3.setVisibility(View.VISIBLE);
                    btnTolerance.setVisibility(View.VISIBLE);
                    btnCoefficient.setVisibility(View.VISIBLE);
                    Tolerance.setVisibility(View.VISIBLE);
                    Coefficient.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }
}
