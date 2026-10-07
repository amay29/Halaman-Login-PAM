package lat.pam.halamanloginpam

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import lat.pam.halamanloginpam.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        binding.tilUsername.error = null
        binding.tilPassword.error = null

        if (username.isEmpty()) {
            binding.tilUsername.error = getString(R.string.empty_fields_error)
            return
        }

        if (password.isEmpty()) {
            binding.tilPassword.error = getString(R.string.empty_fields_error)
            return
        }

        if ((username == "damar29") && (password == "Apaaja123")) {
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("EXTRA_USERNAME", username)
                putExtra("EXTRA_NAMA", "Damar")
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
            binding.tilPassword.error = getString(R.string.login_failed)
        }
    }
}