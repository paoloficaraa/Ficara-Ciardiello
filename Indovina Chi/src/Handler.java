
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    private LinkedList<Person> listPeople = new LinkedList<Person>(); //lista delle persone

    public void addPeople() {
        MyFile file = new MyFile("src\\Persone\\filePersone.txt"); //persone già costruite dentro questo file di testo
        List<String> persone = file.leggi();
        for (String s : persone) {
            String[] temp = s.split(";");
            addPerson(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Toolkit.getDefaultToolkit().getImage(temp[2]),
                    Boolean.parseBoolean(temp[3]), Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]), Boolean.parseBoolean(temp[6]),
                    Boolean.parseBoolean(temp[7]), Boolean.parseBoolean(temp[8]), Boolean.parseBoolean(temp[9]), temp[10], temp[11], temp[12]));
        }
    }

    public void render(Graphics g) {
        for (Person object : listPeople) {
            Person temp = object;
            temp.render(g);
        }
    }

    public void addPerson(Person object) {
        listPeople.add(object);
    }

    public void removePerson(Person object) {
        listPeople.remove(object);
    }

    public LinkedList<Person> getListPeople() {
        return listPeople;
    }
}
