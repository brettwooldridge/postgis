/*
 * PGgeometryLW.java
 * 
 * PostGIS extension for PostgreSQL JDBC driver - PGobject LWGeometry Wrapper
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

/**
 * This is a subclas of PGgeometry that uses hex encoded EWKB to communicate
 * with the backend, which is much more efficient, but only works with Lwgeom
 * enabled PostGIS (1.0.0 and up).
 */

public class PGgeometryLW extends PGgeometry {
    /* JDK 1.5 Serialization */
    private static final long serialVersionUID = 0x100;
    
    public PGgeometryLW() {
        super();
    }

    public PGgeometryLW(Geometry geom) {
        this();
        geoImpl = new PGgeometryLWImpl(geom);
    }

    public PGgeometryLW(String value) throws SQLException {
        this();
        setValue(value);
    }

    @Override
    public void setValue(String value) throws SQLException {
    	geoImpl = new PGgeometryLWImpl(value);
    }

    @Override
    public Object clone() {
        return new PGgeometryLW(getGeometry());
    }
}
