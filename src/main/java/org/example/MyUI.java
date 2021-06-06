
package org.example;

        import javax.servlet.annotation.WebServlet;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.vaadin.annotations.Theme;
        import com.vaadin.annotations.VaadinServletConfiguration;
        import com.vaadin.server.VaadinRequest;
        import com.vaadin.server.VaadinServlet;
        import com.vaadin.ui.*;
        import com.vaadin.ui.components.grid.ItemClickListener;
        import com.vaadin.ui.renderers.ButtonRenderer;

        import java.io.*;
        import java.util.concurrent.atomic.AtomicInteger;

        import static java.lang.Integer.getInteger;
        import static java.lang.Integer.valueOf;

@Theme("mytheme")
public class MyUI extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Peliculas listausuarios = new Peliculas();
        TitulosP listatitulos = new TitulosP();

        Gson gson = new Gson();
        Gson gson2 = new GsonBuilder().create();

        Grid<Pelicula> grid = new Grid<>(Pelicula.class);
        Grid<TituloP> grid2 = new Grid<>(TituloP.class);

        //AtomicInteger id = new AtomicInteger();
        final AtomicInteger[] NId = {new AtomicInteger()};
        final AtomicInteger[] NId2 = {new AtomicInteger()};

        // String s=String.valueOf(i);

        final VerticalLayout layout = new VerticalLayout();



        Button button1 = new Button("Crear Pelicula");
        button1.addClickListener(e -> {

            TextField tituloT = new TextField();

            final TextField titulo = new TextField();
            titulo.setCaption("Introduzca el titulo:");

            tituloT = titulo;

            final TextField sinopsis = new TextField();
            sinopsis.setCaption("Introduzca la sinopsis:");

            final TextField genero = new TextField();
            genero.setCaption("Introduzca el genero:");

            final TextField enlace = new TextField();
            enlace.setCaption("Introduzca el enlace:");

            final TextField reparto = new TextField();
            reparto.setCaption("Introduzca el reparto (Actores y/o actrices):");



            Button button = new Button("Guardar Pelicula");
            TextField finalTituloT = tituloT;
            button.addClickListener(e2 -> {
                Pelicula u = new Pelicula(titulo.getValue(), sinopsis.getValue(),  genero.getValue(),enlace.getValue(), reparto.getValue());
                TituloP u2 = new TituloP(finalTituloT.getValue());

                u.nuevoID(NId[0].get());
                u2.nuevoID(NId2[0].get());

                listausuarios.AddPelicula(u);
                listatitulos.AddTituloP(u2);

                NId[0].addAndGet(1);
                NId2[0].addAndGet(1);

                System.out.println("\n");
                Notification.show("Pelicula guardada");

                grid.setItems(listausuarios.getPeliculas());
                listausuarios.mostrarlista();

                grid2.setItems(listatitulos.getTitulosP());
                //listatitulos.mostrarlistaT();

                layout.removeComponent(titulo);
                layout.removeComponent(sinopsis);
                layout.removeComponent(genero);
                layout.removeComponent(enlace);
                layout.removeComponent(reparto);
                layout.removeComponent(button);


            });
            layout.addComponents(titulo,sinopsis,genero,enlace,reparto, button);


        });

        Button button5=new Button("Almacenar peliculas en una lista");
        button5.addClickListener(e -> {

            try (Writer writer = new FileWriter("Peliculas.json")) {

                gson2.toJson(listausuarios, writer);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            Notification.show("Lista creada");

        });


        //Button button2=new Button("Mostrar peliculas");

        //button2.addClickListener(e -> {

        /*
            grid.setItems(listausuarios.getPeliculas());
            listausuarios.mostrarlista();
            Notification.show("Mostrando lista");
            layout.addComponent(grid);
            */

        //});

        //Button button6=new Button("Leer lista");
        //button6.addClickListener(e -> {

            String fichero = "";

            try (BufferedReader br = new BufferedReader(new FileReader("ListaPeliculas.json"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    fichero += linea;
                }

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            Pelicula data =gson.fromJson(fichero, Pelicula.class);
            listausuarios.AddPelicula(data);
            TituloP data2 = gson.fromJson(fichero, TituloP.class);
            listatitulos.AddTituloP(data2);
            //Notification.show("Pelicula/s importadas");

        //});

        Button button3=new Button("Actualizar pelicula");
        button3.addClickListener(e -> {

            TextField titulo2t = new TextField();

            final TextField id = new TextField();
            id.setCaption("Introduzca el Id de pelicula que desee actualizar:");

            final TextField titulo2 = new TextField();
            titulo2.setCaption("Introduzca el titulo:");

            titulo2t = titulo2;

            final TextField sinopsis2 = new TextField();
            sinopsis2.setCaption("Introduzca los sinopsis:");

            final TextField genero2 = new TextField();
            genero2.setCaption("Introduzca el genero:");

            final TextField enlace2 = new TextField();
            enlace2.setCaption("Introduzca el enlace:");

            final TextField reparto2 = new TextField();
            reparto2.setCaption("Introduzca el reparto:");

            Button button=new Button("Guardar cambios");
            TextField finalTitulo2t = titulo2t;
            button.addClickListener(e2 -> {

                Pelicula update = new Pelicula(titulo2.getValue(), sinopsis2.getValue(), genero2.getValue(),enlace2.getValue(), reparto2.getValue());
                TituloP update2 = new TituloP(finalTitulo2t.getValue());

                update.nuevoID(Integer.parseInt(id.getValue()));
                update2.nuevoID(Integer.parseInt(id.getValue()));

                listausuarios.updatepelicula(Integer.parseInt(id.getValue()), update);
                listatitulos.updateTitulo(Integer.parseInt(id.getValue()), update2);

                Notification.show("Pelicula Actualizada");

                grid.setItems(listausuarios.getPeliculas());
                listausuarios.mostrarlista();

                grid2.setItems(listatitulos.getTitulosP());
                //listatitulos.mostrarlistaT();

                layout.removeComponent(id);
                layout.removeComponent(titulo2);
                layout.removeComponent(sinopsis2);
                layout.removeComponent(genero2);
                layout.removeComponent(enlace2);
                layout.removeComponent(reparto2);
                layout.removeComponent(button);

            });

            layout.addComponents(id,titulo2,sinopsis2,genero2,enlace2,reparto2, button);

        });

        Button button4=new Button("Eliminar pelicula");
        button4.addClickListener(e -> {

            TextField numero2t = new TextField();

            final TextField numero2 = new TextField();
            numero2.setCaption("Introduzca el Id de película que desea eliminar:");

            numero2t = numero2;

            Button button8=new Button("Eliminar");
            TextField finalNumero2t = numero2t;
            button8.addClickListener(e2 -> {

                listausuarios.deletepelicula(Integer.parseInt(numero2.getValue()));
                listatitulos.deleteTitulo(Integer.parseInt(finalNumero2t.getValue()));


                Notification.show("Pelicula eliminada");

                grid.setItems(listausuarios.getPeliculas());
                listausuarios.mostrarlista();

                grid2.setItems(listatitulos.getTitulosP());
                //listatitulos.mostrarlistaT();

                layout.removeComponent(numero2);
                layout.removeComponent(button8);

            });
            layout.addComponents(numero2, button8);

        });



        Button button7=new Button("Detalle pelicula");

        button7.addClickListener(e -> {

            final TextField numero3 = new TextField();
            numero3.setCaption("Introduzca el número de pelicula que desea ver en detalle:");
            VerticalLayout popupContent = new VerticalLayout();
            Button button10=new Button("Continuar");

            button10.addClickListener(e2 -> {
                popupContent.addComponent(new Label("Detalles de la pelicula:"));
                String string="";
                string=listausuarios.getPelicula(Integer.parseInt(numero3.getValue()));
                popupContent.addComponent(new Label(string));
                PopupView popup = new PopupView("Ver detalles de la pelicula", popupContent);
                layout.addComponent(popup);

                layout.removeComponent(numero3);
                layout.removeComponent(button10);

            });

            layout.addComponents(numero3,button10);



        });


        grid2.setItems(listatitulos.getTitulosP());


        listausuarios.mostrarlista();
        //listatitulos.mostrarlistaT();
        //Notification.show("Mostrando lista");
        layout.addComponent(grid2);

        layout.addComponents(button1,button3,button4,button5,button7);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private class NativeButtonRenderer {
        public NativeButtonRenderer(String details, Object o) {
        }
    }
}