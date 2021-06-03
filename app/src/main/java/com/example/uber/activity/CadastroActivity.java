package com.example.uber.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.example.uber.R;
import com.example.uber.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText campoNome, campoEmail, campoSenha;
    private Switch switchTipoUsuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //inicializar os componentes
        campoNome = findViewById(R.id.editCadastroNome);
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        switchTipoUsuario = findViewById(R.id.switchTipoUsuario);

    }

    public void  validarCadastroUsuario(){

        //recuperar textos dos campos
        String textoNome = campoNome.getText().toString();
        String textoEmail = campoEmail.getText().toString();
        String textoSenha = campoSenha.getText().toString();

        if(!textoNome.isEmpty()){ //verifica o nome
            if(!textoEmail.isEmpty()){ //verifica o e-mail
                if(!textoSenha.isEmpty()){ //verifica senha

                    Usuario usuario = new Usuario();
                    usuario.setNome( textoNome );
                    usuario.setEmail( textoEmail );
                    usuario.setSenha( textoSenha );
                    usuario.setTipo( verificaTipoUsuario() );

                    cadastrarusuario( usuario );

                }else {
                    Toast.makeText(CadastroActivity.this, "Preencha o campo senha!", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(CadastroActivity.this, "Preencha o campo email !", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(CadastroActivity.this, "Preencha o campo nome!", Toast.LENGTH_SHORT).show();
        }

    }

    public String verificaTipoUsuario(){

        return switchTipoUsuario.isChecked() ? "M" : "P";

    }

    public void cadastrarusuario( Usuario usuario){


    }
}