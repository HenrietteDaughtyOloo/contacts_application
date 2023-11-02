package com.henriette.contactsapplication.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.health.connect.datatypes.ExerciseRoute.Location
import android.os.Bundle
import android.os.Environment
import android.os.Looper
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.henriette.contactsapplication.R
import com.henriette.contactsapplication.databinding.ActivityAddContactBinding
import com.henriette.contactsapplication.model.Contact
import com.henriette.contactsapplication.viewmodel.ContactsViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.io.File

class AddContact : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactViewModel: ContactsViewModel by viewModels()
    lateinit var photoFile: File
    lateinit var fusedLocationClient : FusedLocationProviderClient
    lateinit var myLocation: android.location.Location

    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        result->
        if (result.resultCode == Activity.RESULT_OK){
            Picasso
                .get()
                .load(File(photoFile.absolutePath))
                .resize(80, 80)
//                .placeholder(R.drawable.boaz)
                .transform(CropCircleTransformation())
                .into(binding.ivAddAvatar)
        }
    }
    val locationRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            result->
        if (checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            getLocationUpdates()
        }
        else{
            Toast.makeText(this, "Please Grant Location Permission", Toast.LENGTH_LONG).show()
        }

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient=LocationServices.getFusedLocationProviderClient(this)
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnSave.setOnClickListener {
            validateAddContact()
        }



        }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            validateAddContact()
        }
        binding.ivAddAvatar.setOnClickListener{
            capturePhoto()
        }
        getLocationUpdates()



    }
    fun getLocationUpdates() {
        if (checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
           val locationRequest = LocationRequest.Builder(10000)
//               .setIntervalMillis(1000)
//               .setFastestIntervalMillis(5000)
               .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
               .build()

            val locationCallBack =object :LocationCallback(){
                override fun onLocationResult(p0: LocationResult) {
                    super.onLocationResult(p0)
                    for (location in p0.locations){
                        Toast
                            .makeText(
                                baseContext,
                                "Lat: ${location.latitude}, long: ${location.longitude}",
                                Toast.LENGTH_SHORT
                            ).show()


                    }
                }
            }

            fusedLocationClient.requestLocationUpdates(locationRequest,locationCallBack,Looper.getMainLooper())
        //                Priority.PRIORITY_BALANCED_POWER_ACCURACY,
//                CancellationTokenSource().token)
//                .addOnSuccessListener { location ->
//                myLocation= location
//                Toast
//                    .makeText(
//                        this,
//                        "Lat: ${location.latitude}, long: ${location.longitude}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//            }
        }
        else{
            locationRequest.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }

    }



    fun validateAddContact() {
        clearErrors()
        val addName = binding.etAddName.text.toString()
        val addPhoneNumber = binding.etAddPhoneNumber.text.toString()
        val addEmail = binding.etAddEmail.text.toString()
//        val addPhoto = binding.ivAddAvatar.text.toString()
        var error = false
        if (addName.isBlank()) {
            binding.etAddName.error = getString(R.string.name_required)

            error = true
        }
        if (addPhoneNumber.isBlank()) {
            binding.etAddPhoneNumber.error = getString(R.string.number_required)
            error = true
        }
        if (addEmail.isBlank()) {
            binding.etAddEmail.error = getString(R.string.email_required)
            error = true
        }

        if (!error) {
            val newContact=Contact(0, avatar =photoFile.absolutePath,addName,addPhoneNumber,addEmail,)
            contactViewModel.saveContact(newContact)
            Toast.makeText(
                this, "Contact added Successfully", Toast.LENGTH_LONG
            )
                .show()
            finish()

        }

    }

    fun clearErrors() {
        binding.etAddName.error = null
        binding.etAddPhoneNumber.error = null
        binding.etAddEmail.error = null
    }

     fun capturePhoto() {
        binding.ivAddAvatar.setOnClickListener{
            val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = getPhotoFile("photo_${System.currentTimeMillis()}")
            val fileProvider = FileProvider.getUriForFile(this,
                "com.henriette.contactsapplication.provider",
                photoFile)
            photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
            cameraLauncher.launch(photoIntent)
        }
    }

    fun getPhotoFile(fileName: String): File {
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val tempFile = File.createTempFile(fileName, ".jpg", storageDir)
        return tempFile
    }



}