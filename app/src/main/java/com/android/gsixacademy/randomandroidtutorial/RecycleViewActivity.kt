package com.android.gsixacademy.randomandroidtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity: AppCompatActivity() {
    var listCars: ArrayList<Car> = arrayListOf()
// the var listCars inherits the pattern of the array from the Class car and fills it with specified info
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        listCars.add(Car("Mclaren","MC description", R.drawable.mclaren))
        listCars.add(Car("Honda","Honda description", R.drawable.honda_nsx))
        listCars.add(Car("Jaguar","Jaguar description", R.drawable.jaguar_f))
        listCars.add(Car("Mercedes","Mercedes description", R.drawable.mercedes_amg))
        listCars.add(Car("Audi","Audi", R.drawable.audi_r))
        listCars.add(Car("Aston Martin","MC description", R.drawable.aston_martin))
        listCars.add(Car("Aston Martin 2", "Aston Martin Description ", R.drawable.aston_martin1))
        listCars.add(Car("Maserati", "Maserati Description ", R.drawable.maserati_granturismo))
        listCars.add(Car("Nissan", "Nissan Description ", R.drawable.nissan))

            // this will help us to fill the array with 100 (as specified below) objects from the type Nissan
        for (i in 0..100){
            listCars.add(Car("Nissan", "Nissan Description"+i, R.drawable.nissan))
        }
        var carsAdapter:CarsAdapter=CarsAdapter(listCars)
        recycler_view_activities.adapter=carsAdapter
        }

    }

