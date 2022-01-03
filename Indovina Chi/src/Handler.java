
import java.awt.Graphics;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ficara_paolo
 */
//Classe gestore che gestisce ogni oggetto del gioco
public class Handler {

    LinkedList<Person> listPerson = new LinkedList<Person>();
    
    public void tick() {
        for (Person object : listPerson) {
            Person temp = object;
        }
    }

    public void render(Graphics g) {
        for (Person object : listPerson) {
            Person temp = object;
            temp.render(g);
        }
    }

    public void addPerson(Person object) {
        listPerson.add(object);
    }

    public void removePerson(Person object) {
        listPerson.remove(object);
    }

}
