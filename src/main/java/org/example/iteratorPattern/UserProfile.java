package org.example.iteratorPattern;

import org.example.entities.SocialNetworkProfile;


import java.util.LinkedList;
import java.util.List;




public class UserProfile implements SocialNetworkProfile, SocialNetwokIterable<ProfileIterator<SocialNetworkProfile>> {

    private List<SocialNetworkProfile> following;
    private String userName;
    private int age;

    public UserProfile(String userName, int age) {
        this.following = new LinkedList<>();
        this.userName = userName;
        this.age = age;
    }

    public void addFollowing(SocialNetworkProfile... profiles) {
        for (SocialNetworkProfile profile : profiles) {
            this.following.add(profile);
        }
    }

    public List<SocialNetworkProfile> getFollowing() {
        return this.following;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserProfile other) {
            return other.getUserName().equals(this.userName) && other.age == this.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        Integer n = age;
        return userName.hashCode() + n.hashCode();
    }

    @Override
    public String toString() {
        return "I'm " + userName + " and I'm " + age + " years old";
    }

    @Override
    public ProfileIterator<SocialNetworkProfile> iterator() {
        return new ProfileIteratorUsers(this);
    }

    // Método para el iterador DFS
    public ProfileIterator<SocialNetworkProfile> iteratorDFS() {
        return new ProfileIteratorDFS(this); // Instancia de la clase ProfileIteratorDFS
    }

    // Método para el iterador solo de empresas
    public ProfileIterator<SocialNetworkProfile> iteratorEnterprises() {
        return new ProfileIteratorEnterpriseOnly(this); // Instancia de la clase ProfileIteratorEnterpriseOnly
    }
}
