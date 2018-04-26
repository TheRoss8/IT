package gq.francescorossato.mailclient.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by francesco.rossato on 16/02/2018.
 */
public class Message {
    private StringProperty subject = new SimpleStringProperty();
    private StringProperty from = new SimpleStringProperty();
    private StringProperty to = new SimpleStringProperty();
    private StringProperty message = new SimpleStringProperty();
    private StringProperty date = new SimpleStringProperty();

    public String getSubject() {
        return subject.get();
    }
    public String getFrom() {
        return from.get();
    }
    public String getTo() {
        return to.get();
    }
    public String getMessage() {
        return message.get();
    }
    public String getDate() {
        return date.get();
    }

    public StringProperty subjectProperty() {
        return subject;
    }
    public StringProperty fromProperty() {
        return from;
    }
    public StringProperty toProperty() {
        return to;
    }
    public StringProperty messageProperty() {
        return message;
    }
    public StringProperty dateProperty() {
        return date;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }
    public void setFrom(String from) {
        this.from.set(from);
    }
    public void setTo(String to) {
        this.to.set(to);
    }
    public void setMessage(String message) {
        this.message.set(message);
    }
    public void setDate(String date) {
        this.date.set(date);;
    }
}
