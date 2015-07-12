package me.sgrouples;

import org.apache.solr.client.solrj.embedded.JettySolrRunner;

class SolrStarter {
    public static void main(String[] args) {
        String path = ".";
        int port = 8983;
        String context = "/solr";
        if (args.length > 0) path = args[0];
        if (args.length > 1) port = Integer.parseInt(args[1]);
        if (args.length > 2) context = args[2];
        try {
            JettySolrRunner ex = new JettySolrRunner(path, context, port);
            ex.start();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }
}
