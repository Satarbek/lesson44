package model;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import server.BasicServer;
import server.ContentType;
import server.ResponseCodes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainServer extends BasicServer {

    private final static Configuration freemarker = initFreeMarker();

    public MainServer(String host, int port) throws IOException{
        super(host, port);
        registerGet("/books", this::booksListHandler);
        registerGet("/booksinfo", this::firstBooksInfoHandler);
        registerGet("/users", this::usersHandler);
    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("data"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void booksListHandler(HttpExchange exchange) {
        renderTemplate(exchange, "books.html", getBookListModel());
    }

    private void firstBooksInfoHandler(HttpExchange exchange) {
        renderTemplate(exchange, "booksinfo.html", getBookInfoModel());
    }

    private void usersHandler(HttpExchange exchange) {
        renderTemplate(exchange, "users.html", getUserModel());
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            Template temp = freemarker.getTemplate(templateFile);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {

                temp.process(dataModel, writer);
                writer.flush();

                var data = stream.toByteArray();
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private BooksListModel getBookListModel() {
       return new BooksListModel();
    }

    private BookInfoModel getBookInfoModel() {
        return new BookInfoModel();
    }



    private UsersModel getUserModel() {
        return new UsersModel();
    }
}
