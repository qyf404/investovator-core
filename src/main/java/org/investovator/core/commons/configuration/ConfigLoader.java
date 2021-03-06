/*
 * investovator, Stock Market Gaming framework
 * Copyright (C) 2013  investovator
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.investovator.core.commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.util.Iterator;

/**
 * @author rajith
 * @version $Revision$
 */
public class ConfigLoader {

    /**
     *
     * @param filePath specify path to the properties file
     * @throws ConfigurationException
     */
    public static void loadProperties(String filePath) throws ConfigurationException {

        Configuration configuration =
                new PropertiesConfiguration(new File(filePath).getAbsolutePath());

        Iterator<String> iterator = configuration.getKeys();
        while (iterator.hasNext()){
            String key = iterator.next();
            String[] properties = configuration.getStringArray(key);
            StringBuilder value = new StringBuilder(properties[0]);
            for(int i = 1; i < properties.length; i++){
               value.append(",").append(properties[i]);
            }
            System.setProperty(key, value.toString());
        }
    }

}
