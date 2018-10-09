/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.model;

/**
 *
 * @author madave91
 */

import lombok.Data;
import javax.persistence.*;

/*A @MappedSuperclass annotáció mondja meg a JPA-nak, hogy ezt az osztályt nem fogjuk önmagában entitásként kezelni,
csak felhasználjuk más entitásoknál. A @Data annotáció a Lombok-ból jön, segítségévle automatikusan kigenerálódnak a getterek,
setterek equals, és hashcode metódusok. Az @Id mondja meg, hogy a mező fogja azonosítani az egyes entitásokat,
és automatikusan generáljuk az értékeit egy inkrementális stratégiával. A @Version használatára azért van szükség,
mert egyszerre több felhasználó is módosíthatja az adatokat, ilyenkor ez a változó segíti a fennakadás mentes munkát
( minden a háttérben történik, ezzel nem kell foglalkoznunk)
*/

@Data
@MappedSuperclass               
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Version
    private int version;
}
