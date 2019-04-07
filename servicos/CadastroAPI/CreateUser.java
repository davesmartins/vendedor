public ValidaLogin () {

if(jTextField1.getText().equals("") || jPasswordField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Login ou Senha inválido.", "Ok", JOptionPane.ERROR_MESSAGE);
        }else{
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://db.mysql.davesmartins.com.br/vendedor_usuario"," user_v5"," v1v2v3v4v5");
                Statement stm = con.createStatement();
                String SQL = "Select * from vendedor_usuario where login = '"+ jTextField1.getText()+"';";
                ResultSet rs = stm.executeQuery(SQL);
                while(rs.next()) {
                    String loginn = rs.getString("login");
                    String senhaa = rs.getString("senha");
                    String nomee = rs.getString("nome");
                    String emaill = rs.getString("email");
                    if(jTextField1.getText().equals(loginn) && jPasswordField1.getText().equals(senhaa)){
                        JOptionPane.showMessageDialog(null,"Seja bem vindo: " + nomee,"Ok",JOptionPane.INFORMATION_MESSAGE);
                        jLabel2.setText(nomee);
                        jLabel6.setText(emaill);
                    }else{
                        JOptionPane.showMessageDialog(null,"Login ou Senha inválidos.","Ok",JOptionPane.ERROR_MESSAGE);
                        jPasswordField1.setText("");
                    }
                }
            }catch(SQLException e){
                e.printStackTrace(); 
                JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Ok",JOptionPane.WARNING_MESSAGE);
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Ok",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                }
            } 
        }

        jTextField1.setText("");
        jPasswordField1.setText("");
}