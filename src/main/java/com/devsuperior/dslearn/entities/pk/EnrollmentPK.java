package com.devsuperior.dslearn.entities.pk;

import com.devsuperior.dslearn.entities.Offer;
import com.devsuperior.dslearn.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class EnrollmentPK {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public EnrollmentPK() {

    }

    public EnrollmentPK(Offer offer, User user) {
        this.offer = offer;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        EnrollmentPK that = (EnrollmentPK) o;
        return Objects.equals(user, that.user) && Objects.equals(offer, that.offer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(offer);
        return result;
    }
}
