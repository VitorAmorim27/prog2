import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        User admin = new User("admin", "admin", "Administrador", 0, Tipo.ADMIN);
        users.add(admin);
        File file = new File("users.dat");
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream("users.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(users);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        users = carregarUsers();

        File file1 = new File("projetos.dat");
        if(!file1.exists()){
            try{
                file1.createNewFile();
                FileOutputStream fos = new FileOutputStream("projetos.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(projetos);
            } catch (IOException e ) {
                e.printStackTrace();
            }
        }
        projetos = carregarProjetos();
        tarefas = carregarTarefas();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1- Criar Conta");
            System.out.println("2- Login");
            System.out.println("3- Sair");
            System.out.println("Escolha uma opção: ");
        /* for (User user:users) {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());

        }*/

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome de Utilizador: ");
                    String username = scanner.next();
                    System.out.println("Password: ");
                    String password = scanner.next();
                    System.out.println("Nome: ");
                    String name = scanner.next();
                    System.out.println("Horas Diárias: ");
                    int hours = scanner.nextInt();
                    User user = new User(username, password, name, hours, Tipo.USER);
                    registerUser(users, user);
                    break;
                case 2:
                    User user1 = new User();
                    do {
                        System.out.print("Nome de Utilizador: ");
                        String uname = scanner.next();
                        System.out.print("Password: ");
                        String pw = scanner.next();

                        user1 = login(uname, pw, users);
                    } while (user1.equals(null));
                    if (user1.getTipo() == Tipo.ADMIN) {
                        System.out.println("Bem-Vindo " + user1.getNome() + "!");
                        AdminMenu(users, projetos, tarefas);
                    } else if (user1.getTipo() == Tipo.USER_MANAGER) {
                        System.out.println("Bem-Vindo " + user1.getNome() + "!");
                        userManagerMenu(users);
                    } else if (user1.getTipo() == Tipo.USER) {
                        System.out.println("Bem-Vindo " + user1.getNome() + "!");
                        userMenu(users);
                    }
                    break;
                case 3:
                    return;
            }
        }
    }

    public static User login(String username, String password,ArrayList<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login efetuado com sucesso");
                return user;
            }
        }
        System.out.println("Nome de Utilizador ou password inválidas!");
        return null;
    }

    public static ArrayList<User> registerUser(ArrayList<User> users,User user) {
        // serialize the user object and save it to a file
        try (FileOutputStream fos = new FileOutputStream("users.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            users.add(user);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<User> carregarUsers() throws Exception {
        FileInputStream fileIn = new FileInputStream("users.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<User> users = (ArrayList<User>) in.readObject();
        in.close();
        fileIn.close();
        return users;
    }

    public static ArrayList<Projeto> registarProjeto(ArrayList<Projeto> projetos, Projeto projeto){

        projetos.add(projeto);
        return projetos;

    }

    public static ArrayList<Projeto> EscreverFicheiro(ArrayList<Projeto> projetos){

        try (FileOutputStream fos = new FileOutputStream("projetos.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(projetos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    public static ArrayList<Projeto> carregarProjetos() throws Exception {
        FileInputStream fileIn = new FileInputStream("projetos.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Projeto> projetos = (ArrayList<Projeto>) in.readObject();
        in.close();
        fileIn.close();
        return projetos;
    }

    public static ArrayList<Tarefa> registarTarefas(ArrayList<Tarefa> tarefas, Tarefa tarefa){

        tarefas.add(tarefa);
        return tarefas;

    }

    public static ArrayList<Tarefa> EscreverFicheiroTarefas(ArrayList<Tarefa> tarefas){

        try (FileOutputStream fos = new FileOutputStream("tarefas.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(tarefas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tarefas;
    }

    public static ArrayList<Tarefa> carregarTarefas() throws Exception {
        FileInputStream fileIn = new FileInputStream("tarefas.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) in.readObject();
        in.close();
        fileIn.close();
        return tarefas;
    }

    public static void userMenu(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu do Utilizador");
        System.out.println("1- Ver Projetos");
        System.out.println("2- Ver tarefas");
        System.out.println("3- Editar informações");
        System.out.println("4 - Sair");

        int op1 = scanner.nextInt();

        switch (op1){
            case 1:
                int i = 1;
                System.out.println(i);
                break;
            case 2:
                int a = 2;
                System.out.println(a);
                break;
            case 3:
                System.out.println("aa");
                break;
            case 4:
                return;

        }
    }

    public static void userManagerMenu(ArrayList<User> users){
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> u1 = new ArrayList<>();
        Projeto proj = new Projeto();

        System.out.println("Menu do UserManager");
        System.out.println("1- Criar utilizador");
        System.out.println("2- Editar permissões");
        System.out.println("3- Criar/Ver Projetos");
        System.out.println("4- Criar/Ver tarefas");
        System.out.println("5- Editar Informações");
        System.out.println("6- Sair");

        int op2 = scanner.nextInt();

        switch (op2){
            case 1:
                System.out.println("Nome de Utilizador: ");
                String username = scanner.next();
                System.out.println("Password: ");
                String password = scanner.next();
                System.out.println("Nome: ");
                String name = scanner.next();
                System.out.println("Horas Diárias: ");
                int hours = scanner.nextInt();
                User user = new User(username, password, name, hours, Tipo.USER);
                registerUser(users, user);
                proj.addUser(u1);
                break;
            case 2:
                int a = 2;
                System.out.println(a);
                break;
            case 3:
                System.out.println("aa");
                break;
            case 4:
                System.out.println("a");
                break;
            case 5:
                System.out.println("b");
                break;
            case 6:
                return;
        }
    }

    public static void AdminMenu(ArrayList<User> users, ArrayList<Projeto> projetos, ArrayList<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> u1 = new ArrayList<>();
        Projeto proj = new Projeto();
        Tarefa task = new Tarefa();

        System.out.println("Menu do Administrador");
        System.out.println("1- Criar utilizador");
        System.out.println("2- Editar permissões");
        System.out.println("3- Criar/Ver Projetos");
        System.out.println("4- Criar/Ver tarefas");
        System.out.println("5- Editar Informações");
        System.out.println("6 - Sair e guardar");

        int op2 = scanner.nextInt();
        int op3 = scanner.nextInt();

        while (true) {
            switch (op2) {
                case 1:
                    System.out.println("Nome de Utilizador: ");
                    String username = scanner.next();
                    System.out.println("Password: ");
                    String password = scanner.next();
                    System.out.println("Nome: ");
                    String name = scanner.next();
                    System.out.println("Horas Diárias: ");
                    int hours = scanner.nextInt();
                    User user = new User(username, password, name, hours, Tipo.USER);
                    registerUser(users, user);
                    proj.addUser(u1);
                    break;
                case 2:
                    int a = 2;
                    System.out.println(a);
                    break;
                case 3:
                    System.out.println("1- Criar projeto");
                    System.out.println("2- Ver projetos");
                    System.out.println("3- Voltar");

                    int opc = scanner.nextInt();
                    if (opc == 1) {
                        System.out.println("Nome do Projeto: ");
                        String nome = scanner.next();
                        System.out.println("Nome do Cliente: ");
                        String nomeCliente = scanner.next();
                        System.out.println("Preço por Hora: ");
                        double precoHora = Double.parseDouble(scanner.next());
                        Projeto projeto = new Projeto(nome, nomeCliente, precoHora);
                        registarProjeto(projetos, projeto);
                    } else if(opc == 2) {
                        if(projetos.size() > 0) {
                            for (Projeto projeto : projetos) {
                                System.out.println("Nome do projeto: " + projeto.getNome());
                                System.out.println("Nome do Cliente: " + projeto.getnomeCliente());
                                System.out.println("Preço por Hora: " + projeto.getPreçoHora());
                                System.out.println("1-Eliminar Projeto");
                                System.out.println("2-Voltar");
                            }

                            int o = scanner.nextInt();
                            if (o == 1) {
                                System.out.println("Nome do Projeto a apagar: ");
                                String n = scanner.next();
                                System.out.println("Nome do Cliente do Projeto a apagar: ");
                                String nC = scanner.next();
                                System.out.println("Nº de horas do Projeto a apagar: ");
                                double pH = scanner.nextDouble();

                                projetos.removeIf(p -> p.getNome().equals(n) && p.getnomeCliente().equals(nC) && p.getPreçoHora() == pH);
                            }
                        } else {
                            System.out.println("Não existe projetos");
                            AdminMenu(users, projetos,tarefas);
                        }
                    } else {
                        AdminMenu(users, projetos,tarefas);
                    }
                    break;
                case 4:
                    System.out.println("1- Criar tarefa");
                    System.out.println("2- Ver tarefas");
                    System.out.println("3- Associar tarefa a projeto");
                    System.out.println("4- Voltar");

                    int opc1 = scanner.nextInt();
                    if(opc1 == 1){
                        System.out.println("Nome da tarefa: ");
                        String nome = scanner.next();
                        System.out.println("Descrição: ");
                        String descricao = scanner.next();
                        System.out.println("Data de início: ");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(scanner.next(), formatter);
                        LocalDateTime startDateTime = LocalDateTime.of(date, LocalTime.of(0, 0));
                        System.out.println("Preço por Hora: ");
                        double precoHora = scanner.nextDouble();
                        Tarefa tarefa = new Tarefa(nome, descricao,startDateTime, precoHora);
                        registarTarefas(tarefas, tarefa);
                    }
                    else if(opc1 == 2) {
                        if (tarefas.size() > 0) {
                            for (Tarefa tarefa : tarefas) {
                                System.out.println("Nome do tarefa: " + tarefa.getNome());
                                System.out.println("Descrição: " + tarefa.getDescricao());
                                System.out.println("Preço por Hora: " + tarefa.getPrecoHora());
                                System.out.println("1-Eliminar Tarefa");
                                System.out.println("2-Voltar");
                            }

                            int o = scanner.nextInt();
                            if (o == 1) {
                                System.out.println("Nome do tarefa a apagar: ");
                                String nome = scanner.next();
                                System.out.println("Descrição da tarefa a apagar: ");
                                String descricao = scanner.next();
                                System.out.println("Nº de horas da tarefa a apagar: ");
                                double pH = scanner.nextDouble();

                                tarefas.removeIf(t -> t.getNome().equals(nome) && t.getDescricao().equals(descricao) && t.getPrecoHora() == pH);
                            }else {
                                System.out.println("Não existe tarefas");
                                AdminMenu(users, projetos, tarefas);
                            }
                        }else if (opc1 == 3){
                            System.out.println("Nome da tarefa a associar: ");
                            String nomeTarefa = scanner.next();
                            System.out.println("Nome do projeto a associar: ");
                            String nomeProjeto = scanner.next();
                            for (Projeto projeto: projetos) {
                                if(nomeProjeto.equals(projeto.getNome())){
                                    task.associarProjeto(nomeProjeto);
                            }else{
                                    System.out.println("Projeto não encontrado");
                                }
                            }
                        }
                    } else {
                        AdminMenu(users, projetos,tarefas);
                    }
                    break;
                case 5:
                    System.out.println("b");
                    break;
                case 6:
                    EscreverFicheiro(projetos);
                    System.exit(0);
            }
        }
    }
}






