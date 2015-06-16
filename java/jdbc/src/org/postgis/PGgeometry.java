/*
 * PGgeometry.java
 * 
 * PostGIS extension for PostgreSQL JDBC driver - PGobject Geometry Wrapper
 * 
 * (C) 2004 Paul Ramsey, pramsey@refractions.net
 * 
 * (C) 2005 Markus Schaber, markus.schaber@logix-tt.com
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 2.1 of the License.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA or visit the web at
 * http://www.gnu.org.
 * 
 */

package org.postgis;

import java.sql.SQLException;

import org.postgresql.util.PGobject;

public class PGgeometry extends PGobject implements IPGobject {
    /* JDK 1.5 Serialization */
    private static final long serialVersionUID = 0x100;

    PGgeometryImpl geoImpl;

    public PGgeometry() {
        super.setType("geometry");
    }

    public PGgeometry(Geometry geom) {
        this();
        this.geoImpl = new PGgeometryImpl(geom);
    }

    public PGgeometry(String value) throws SQLException {
    	this();
        setValue(value);
    }

    @Override
    public String getValue() {
    	return geoImpl.getValue();
    }
    
    @Override
    public void setValue(String value) throws SQLException {
    	geoImpl = new PGgeometryImpl(value);
    }

    public Geometry getGeometry() {
        return geoImpl.getGeometry();
    }

    public void setGeometry(Geometry newgeom) {
        geoImpl.setGeometry(newgeom);
    }
    
    public int getGeoType() {
        return getGeometry().type;
    }

    @Override
    public String toString() {
        return getGeometry().toString();
    }

    @Override
    public Object clone() {
        return new PGgeometry(getGeometry());
    }
}
