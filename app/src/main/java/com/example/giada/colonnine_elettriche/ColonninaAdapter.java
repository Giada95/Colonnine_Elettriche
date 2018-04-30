package com.example.giada.colonnine_elettriche;
/**
 * Created by Giada on 24/04/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.Collections;
import java.util.List;

public class ColonninaAdapter extends BaseAdapter {

    private List<Colonnina> colonnine = Collections.emptyList();
    private Context context;

    /**
     * Costruttore
     *
     * @param context contesto da utilizzare
     */
    public ColonninaAdapter(Context context) {
        this.context = context;
    }

    public void update(List<Colonnina> newList) {
        colonnine = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return colonnine.size();
    }

    @Override
    public Colonnina getItem(int position) {
        return colonnine.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_riga_colonnina, parent, false);
        // Ottengo gli id correnti
        TextView textIndirizzogenerico = (TextView) convertView.findViewById(R.id.textVia);
        TextView textGestore = (TextView) convertView.findViewById(R.id.textDistributore);
        TextView textSupporto = (TextView)convertView.findViewById(R.id.textSupporto);
        // Imposto i valori da visualizzare
        Colonnina colonnina = colonnine.get(position);
        textIndirizzogenerico.setText(colonnina.getIndirizzogenerico());
        textGestore.setText(colonnina.getGestore());
        //textSupporto.setText(colonnina.getSupporto);

        return convertView;
    }
}