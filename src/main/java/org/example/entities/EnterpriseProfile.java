package org.example.entities;

public class EnterpriseProfile implements SocialNetworkProfile{
    private String name;

    public EnterpriseProfile(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Enterprise name: "  + name;
    }
}
