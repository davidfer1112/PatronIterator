package org.example.iteratorPattern;

import org.example.entities.EnterpriseProfile;
import org.example.entities.SocialNetworkProfile;
import org.example.entities.UserProfile;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ProfileIteratorEnterpriseOnly implements ProfileIterator<SocialNetworkProfile> {

    private Set<SocialNetworkProfile> visited;
    private ArrayDeque<SocialNetworkProfile> toVisit;

    public ProfileIteratorEnterpriseOnly(SocialNetworkProfile entryPoint) {
        visited = new HashSet<>();
        toVisit = new ArrayDeque<>();
        addToVisit(entryPoint);
    }

    private void addToVisit(SocialNetworkProfile profile) {
        if (profile instanceof UserProfile user) {
            user.getFollowing().stream()
                    .filter(follower -> follower instanceof EnterpriseProfile) // Filtra solo empresas
                    .filter(follower -> !visited.contains(follower))
                    .forEach(toVisit::add);
        }
    }

    @Override
    public SocialNetworkProfile getNext() {
        if (toVisit.isEmpty()) return null;

        SocialNetworkProfile next = toVisit.pollFirst();
        if (next instanceof UserProfile user) {
            addToVisit(next); // Sigue añadiendo perfiles de empresa
        }
        visited.add(next);
        return next;
    }

    @Override
    public boolean hasNext() {
        return !toVisit.isEmpty();
    }
}
