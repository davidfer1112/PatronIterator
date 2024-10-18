package org.example;

import org.example.entities.*;

import java.util.LinkedList;

import org.example.entities.EnterpriseProfile;
import org.example.entities.UserProfile;

import java.util.LinkedList;

import org.example.iteratorPattern.ProfileIterator;



public class Main {
    public static void main(String[] args) {

        // Configuración de perfiles del grupo 1
        UserProfile user1 = new UserProfile("Diego", 21);
        UserProfile user2 = new UserProfile("Alejandro", 20);
        UserProfile user3 = new UserProfile("Daniel", 40);
        UserProfile user4 = new UserProfile("Maria", 35);
        UserProfile user5 = new UserProfile("Luis", 28);
        UserProfile user6 = new UserProfile("Sara", 30);
        UserProfile user7 = new UserProfile("Andrea", 23);
        UserProfile user8 = new UserProfile("Carlos", 32);
        UserProfile user9 = new UserProfile("Sofia", 25);
        UserProfile user10 = new UserProfile("Miguel", 27);

        EnterpriseProfile enterprise1 = new EnterpriseProfile("IBM");
        EnterpriseProfile enterprise2 = new EnterpriseProfile("Google");
        EnterpriseProfile enterprise3 = new EnterpriseProfile("Apple");
        EnterpriseProfile enterprise4 = new EnterpriseProfile("Microsoft");
        EnterpriseProfile enterprise5 = new EnterpriseProfile("Amazon");

        user1.addFollowing(user2, user3, enterprise1, enterprise2);
        user2.addFollowing(user4, user5, enterprise3);
        user3.addFollowing(user6, user7, enterprise4);
        user4.addFollowing(user8, enterprise5);
        user5.addFollowing(user9, user10, enterprise1, enterprise3);
        user6.addFollowing(user1, user2, enterprise4, enterprise5);
        user7.addFollowing(user3, user5, enterprise2);
        user8.addFollowing(user4, enterprise1, enterprise3);
        user9.addFollowing(user6, enterprise2, enterprise5);
        user10.addFollowing(user1, user7, enterprise4);

        // Recorrido DFS
        System.out.println("\nRecorrido DFS:");
        ProfileIterator<SocialNetworkProfile> dfsIterator = user1.iteratorDFS();
        while (dfsIterator.hasNext()) {
            SocialNetworkProfile profile = dfsIterator.getNext();
            System.out.println(profile);
        }

        // Recorrido solo de empresas
        System.out.println("\nRecorrido solo de empresas:");
        ProfileIterator<SocialNetworkProfile> enterpriseIterator = user1.iteratorEnterprises();
        while (enterpriseIterator.hasNext()) {
            SocialNetworkProfile profile = enterpriseIterator.getNext();
            System.out.println(profile);
        }
    }
}
