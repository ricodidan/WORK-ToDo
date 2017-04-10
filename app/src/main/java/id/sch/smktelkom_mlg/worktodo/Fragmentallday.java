package id.sch.smktelkom_mlg.worktodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.sch.smktelkom_mlg.worktodo.activities.CreateEditActivity;
import id.sch.smktelkom_mlg.worktodo.adapter.ReminderAdapter;
import id.sch.smktelkom_mlg.worktodo.adapter.ViewPageAdapter;


/**
 * Created by Enrico_Didan on 23/01/2017.
 */

public class Fragmentallday extends Fragment implements ReminderAdapter.RecyclerListener {

    @BindView(R.id.tabs)
    PagerSlidingTabStrip pagerSlidingTabStrip;
    /*@BindView(R.id.toolbar) Toolbar toolbar;*/
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.fab_button)
    FloatingActionButton floatingActionButton;

    private boolean fabIsHidden = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_allday, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("ToDo Semua Hari");
        ButterKnife.bind(this, view);

        ViewPageAdapter adapter = new ViewPageAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        pagerSlidingTabStrip.setViewPager(viewPager);
        int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);
    }

    @OnClick(R.id.fab_button)
    public void fabClicked() {
        Intent intent = new Intent(getActivity(), CreateEditActivity.class);
        startActivity(intent);
    }

    public void hideFab() {
        floatingActionButton.hide();
        fabIsHidden = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (fabIsHidden) {
            floatingActionButton.show();
            fabIsHidden = false;
        }
    }


}
