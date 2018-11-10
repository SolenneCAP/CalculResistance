package com.example.astrid.resistance6;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Astrid on 04/02/2016.
 */
public class CouleurResistanceFragment extends Fragment{
    Spinner Valeur1, Valeur2, Valeur3, Multiplicateur, Tolerance, Coefficient, NbAnneaux;
    TextView Resultat;
    int value1, value2, value3;
    float multiplicateur;
    String tolerance, coefficient, ohms;
    DecimalFormat df;
    float resultat;
    Resources res;
    String[] txtvaleur1, txtvaleur, txtmultiplicateur, tabmultiplicateur, txttolerance, tabtolerance, txtcoefficient, tabcoefficient, tabnbanneaux;
    int[] tabvaleur1, tabvaleur;
    View rootView;
    ArrayList<ColorSpinnerAdapterItem> colorsvalue1,colorsvalues,colorsmultiplicator,colorstolerance,colorscoefficient;
    ColorSpinnerAdapter colorSpinnerValue1,colorSpinnerValues,colorSpinnerMultiplicator,colorSpinnerTolerance,colorSpinnerCoefficient;
    ColorSpinnerAdapterItem itemNoir,itemMarron,itemRouge,itemOrange,itemJaune,itemVert,itemBleu,itemViolet,itemGris,itemBlanc,itemOr,itemArgent;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.couleur_resistance, container, false);

        ohms = " Ohms\n";
        df = new DecimalFormat("###.##");

        colorsvalue1 = new ArrayList<>();
        colorsvalues = new ArrayList<>();
        colorsmultiplicator = new ArrayList<>();
        colorstolerance = new ArrayList<>();
        colorscoefficient = new ArrayList<>();

        res=getResources();
        txtvaleur1=res.getStringArray(R.array.Value);
        tabvaleur1= res.getIntArray(R.array.Value2);
        txtvaleur=res.getStringArray(R.array.Valeur);
        tabvaleur= res.getIntArray(R.array.Valeur2);
        txtmultiplicateur = res.getStringArray(R.array.Multiplicateur);
        tabmultiplicateur = res.getStringArray(R.array.Multiplicateur2);
        txttolerance = res.getStringArray(R.array.Tolérance);
        tabtolerance = res.getStringArray(R.array.Tolérance2);
        txtcoefficient = res.getStringArray(R.array.Coefficient);
        tabcoefficient = res.getStringArray(R.array.Coefficient2);
        tabnbanneaux = res.getStringArray(R.array.NbAnneaux);

        Valeur1=rootView.findViewById(R.id.spinnerValue1);
        Valeur2=rootView.findViewById(R.id.spinnerValue2);
        Valeur3=rootView.findViewById(R.id.spinnerValue3);
        Multiplicateur=rootView.findViewById(R.id.spinnerMultiplicateur);
        Tolerance=rootView.findViewById(R.id.spinnerTolerance);
        Coefficient=rootView.findViewById(R.id.spinnerCoefficient);
        NbAnneaux=rootView.findViewById(R.id.spinnerNbAnneaux);
        Resultat=rootView.findViewById(R.id.txtResultat);

        itemNoir = new ColorSpinnerAdapterItem(res.getColor(R.color.noir), "Noir");
        itemMarron = new ColorSpinnerAdapterItem(res.getColor(R.color.marron), "Marron");
        itemRouge = new ColorSpinnerAdapterItem(res.getColor(R.color.rouge), "Rouge");
        itemOrange = new ColorSpinnerAdapterItem(res.getColor(R.color.orange), "Orange");
        itemJaune = new ColorSpinnerAdapterItem(res.getColor(R.color.jaune), "Jaune");
        itemVert = new ColorSpinnerAdapterItem(res.getColor(R.color.vert), "Vert");
        itemBleu = new ColorSpinnerAdapterItem(res.getColor(R.color.bleu), "Bleu");
        itemViolet = new ColorSpinnerAdapterItem(res.getColor(R.color.violet), "Violet");
        itemGris = new ColorSpinnerAdapterItem(res.getColor(R.color.gris), "Gris");
        itemBlanc = new ColorSpinnerAdapterItem(res.getColor(R.color.blanc), "Blanc");
        itemOr = new ColorSpinnerAdapterItem(res.getColor(R.color.or), "Or");
        itemArgent = new ColorSpinnerAdapterItem(res.getColor(R.color.argent), "Argent");

        colorsvalue1.add(itemMarron);
        colorsvalue1.add(itemRouge);
        colorsvalue1.add(itemOrange);
        colorsvalue1.add(itemJaune);
        colorsvalue1.add(itemVert);
        colorsvalue1.add(itemBleu);
        colorsvalue1.add(itemViolet);
        colorsvalue1.add(itemGris);
        colorsvalue1.add(itemBlanc);

        colorsvalues.add(itemNoir);
        colorsvalues.add(itemMarron);
        colorsvalues.add(itemRouge);
        colorsvalues.add(itemOrange);
        colorsvalues.add(itemJaune);
        colorsvalues.add(itemVert);
        colorsvalues.add(itemBleu);
        colorsvalues.add(itemViolet);
        colorsvalues.add(itemGris);
        colorsvalues.add(itemBlanc);

        colorsmultiplicator.add(itemNoir);
        colorsmultiplicator.add(itemMarron);
        colorsmultiplicator.add(itemRouge);
        colorsmultiplicator.add(itemOrange);
        colorsmultiplicator.add(itemJaune);
        colorsmultiplicator.add(itemVert);
        colorsmultiplicator.add(itemBleu);
        colorsmultiplicator.add(itemViolet);
        colorsmultiplicator.add(itemGris);
        colorsmultiplicator.add(itemBlanc);
        colorsmultiplicator.add(itemOr);
        colorsmultiplicator.add(itemArgent);

        colorstolerance.add(itemMarron);
        colorstolerance.add(itemRouge);
        colorstolerance.add(itemVert);
        colorstolerance.add(itemBleu);
        colorstolerance.add(itemViolet);
        colorstolerance.add(itemGris);
        colorstolerance.add(itemOr);
        colorstolerance.add(itemArgent);

        colorscoefficient.add(itemMarron);
        colorscoefficient.add(itemRouge);
        colorscoefficient.add(itemOrange);
        colorscoefficient.add(itemJaune);
        colorscoefficient.add(itemBleu);
        colorscoefficient.add(itemViolet);
        colorscoefficient.add(itemBlanc);

        colorSpinnerValue1 = new ColorSpinnerAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, colorsvalue1);
        colorSpinnerValues = new ColorSpinnerAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, colorsvalues);
        colorSpinnerMultiplicator = new ColorSpinnerAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, colorsmultiplicator);
        colorSpinnerTolerance = new ColorSpinnerAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, colorstolerance);
        colorSpinnerCoefficient = new ColorSpinnerAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, colorscoefficient);

        Valeur1.setAdapter(colorSpinnerValue1);
        Valeur2.setAdapter(colorSpinnerValues);
        Valeur3.setAdapter(colorSpinnerValues);
        Multiplicateur.setAdapter(colorSpinnerMultiplicator);
        Tolerance.setAdapter(colorSpinnerTolerance);
        Coefficient.setAdapter(colorSpinnerCoefficient);

        Valeur1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                for (int i = 0; i < colorsvalue1.size(); i++) {
                    if (txtvaleur1[i].equals(colorsvalue1.get(pos).getDisplayName())) {
                        value1 = tabvaleur1[i];
                    }
                }
                affichage();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });

        Valeur2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                for(int i=0; i<colorsvalues.size();i++) {
                    if(txtvaleur[i].equals(colorsvalues.get(pos).getDisplayName())) {
                        value2=tabvaleur[i];
                    }
                }
                affichage();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });

        Valeur3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                for(int i=0; i<colorsvalues.size();i++) {
                    if(txtvaleur[i].equals(colorsvalues.get(pos).getDisplayName())) {
                        value3=tabvaleur[i];
                    }
                }
                affichage();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });

        Multiplicateur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                for(int i=0; i<colorsmultiplicator.size();i++) {
                    if(txtmultiplicateur[i].equals(colorsmultiplicator.get(pos).getDisplayName())) {
                        multiplicateur=Float.valueOf(tabmultiplicateur[i]);
                    }
                }
                affichage();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });

        Tolerance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                for (int i = 0; i < colorstolerance.size(); i++) {
                    if (txttolerance[i].equals(colorstolerance.get(pos).getDisplayName())) {
                        tolerance = tabtolerance[i];
                    }
                }
                affichage();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });

        Coefficient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                for (int i = 0; i < colorscoefficient.size(); i++) {
                    if (txtcoefficient[i].equals(colorscoefficient.get(pos).getDisplayName())) {
                        coefficient = tabcoefficient[i];
                    }
                }
                affichage();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });

        NbAnneaux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(tabnbanneaux[0].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    Valeur3.setVisibility(View.INVISIBLE);
                    Tolerance.setVisibility(View.INVISIBLE);
                    Coefficient.setVisibility(View.INVISIBLE);
                }
                if(tabnbanneaux[1].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    Valeur3.setVisibility(View.INVISIBLE);
                    Tolerance.setVisibility(View.VISIBLE);
                    Coefficient.setVisibility(View.INVISIBLE);
                }
                if(tabnbanneaux[2].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    Valeur3.setVisibility(View.VISIBLE);
                    Tolerance.setVisibility(View.VISIBLE);
                    Coefficient.setVisibility(View.INVISIBLE);
                }
                if(tabnbanneaux[3].equals(NbAnneaux.getItemAtPosition(position).toString())){
                    Valeur3.setVisibility(View.VISIBLE);
                    Tolerance.setVisibility(View.VISIBLE);
                    Coefficient.setVisibility(View.VISIBLE);
                }
                affichage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });

        return rootView;
    }

    public void affichage(){
        String txtResultat = "";
        if(Valeur3.getVisibility()==View.VISIBLE) {
            resultat = ((value1 * 100) + (value2 * 10) + value3) * multiplicateur;
        }else{
            resultat = ((value1 * 10) + value2) * multiplicateur;
        }
        if(resultat>=1000000000){ ohms=" GΩ\n"; resultat/=1000000000; }
        else if(resultat>=1000000){ ohms=" MΩ\n"; resultat/=1000000; }
        else if(resultat>=1000){ ohms=" kΩ\n"; resultat/=1000; }
        else { ohms=" Ω\n"; }
        if(Tolerance.getVisibility()==View.VISIBLE && Coefficient.getVisibility()==View.VISIBLE) {
            txtResultat = String.valueOf(df.format(resultat)) + ohms + "± " + tolerance + "\n" + coefficient;
        }else if(Tolerance.getVisibility()==View.VISIBLE && Coefficient.getVisibility()==View.INVISIBLE){
            txtResultat = String.valueOf(df.format(resultat)) + ohms + "± " + tolerance;
        }else if(Tolerance.getVisibility()==View.INVISIBLE && Coefficient.getVisibility()==View.INVISIBLE){
            txtResultat = String.valueOf(df.format(resultat)) + ohms + "± " + "20%";
        }
        Resultat.setText(txtResultat);
    }
}
