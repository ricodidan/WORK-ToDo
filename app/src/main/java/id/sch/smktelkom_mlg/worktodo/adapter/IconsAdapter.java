package id.sch.smktelkom_mlg.worktodo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smktelkom_mlg.worktodo.R;
import id.sch.smktelkom_mlg.worktodo.database.DatabaseHelper;
import id.sch.smktelkom_mlg.worktodo.dialogs.IconPicker;
import id.sch.smktelkom_mlg.worktodo.model.Icon;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.ViewHolder> {

    private IconPicker iconPicker;
    private List<Icon> iconList;

    public IconsAdapter(IconPicker iconPicker, List<Icon> iconList) {
        this.iconPicker = iconPicker;
        this.iconList = iconList;
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_icon_grid, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final String iconName = iconList.get(position).getName();
        final int iconResId = viewHolder.view.getContext().getResources().getIdentifier(iconName, "drawable", viewHolder.view.getContext().getPackageName());
        viewHolder.imageView.setImageResource(iconResId);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper database = DatabaseHelper.getInstance(viewHolder.view.getContext());
                iconList.get(viewHolder.getAdapterPosition()).setUseFrequency(iconList.get(viewHolder.getAdapterPosition()).getUseFrequency() + 1);
                database.updateIcon(iconList.get(viewHolder.getAdapterPosition()));
                database.close();

                String name;
                if (!iconName.equals(viewHolder.view.getContext().getString(R.string.default_icon_value))) {
                    name = viewHolder.view.getContext().getString(R.string.custom_icon);
                } else {
                    name = viewHolder.view.getContext().getResources().getString(R.string.default_icon);
                }

                ((IconPicker.IconSelectionListener) viewHolder.view.getContext()).onIconSelection(iconPicker, iconName, name, iconResId);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView imageView;
        private View view;

        public ViewHolder(final View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }
    }
}