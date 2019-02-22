package org.driss.ougrimper.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.site.Site;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class SiteLocator extends StrutsTypeConverter {
	
	@Inject
    private ManagerFactory managerFactory;

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Object vRetour = null;

        if (values != null) {
            if (values.length == 1) {
                String vValue = values[0];
                try {
                    vRetour
                        = StringUtils.isEmpty(vValue)
                        ? null
                        :  managerFactory.getSiteManager().getSite(new Integer(vValue));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant site invalide", pEx);
                }
//                catch (NotFoundException pEx) {
//                    throw new TypeConversionException("Site introuvable", pEx);
//                }
            } else {
                vRetour = performFallbackConversion(context, values, toClass);
            }
        }

        return vRetour;
	}

	@Override
	public String convertToString(Map context, Object o) {
		String vString;

        if (o instanceof Site) {
            Site vSite = (Site) o;
            vString
                = vSite.getId() != null
                ? vSite.getId().toString()
                : "";
        } else {
            vString = "";
        }

        return vString;
	}

}
