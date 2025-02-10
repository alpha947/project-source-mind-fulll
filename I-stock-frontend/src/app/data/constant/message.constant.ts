export class Message {
    static COMING_SOON = 'Cette fonctionnalité est en cours de mise à jour, revenez bientôt';
    static GENERIC_SUCCESS_MESSAGE = 'Action réussie';
    static CATEGORY_SAVED = 'Catégorie enregistrée !';
    static INVALID_FORM_FIELDS = `Certains champs sont invalides. <br>Veuillez les corriger et réessayer`;
    static INVALID_ENTRY_TRY_AGAIN = 'Veuillez vérifier vos entrées et réessayer !';
    static VALIDATION_ERROR = 'Erreur de validation';
    static SELECT_PAYMENT_OPTION = 'Sélectionnez une option de paiement';
    static PAYMENT_OPTION_REQUIRED = 'Veuillez vous assurer d\'avoir sélectionné une option de paiement avant de continuer';
    static CART_IS_REQUIRED = 'Le panier est introuvable, veuillez actualiser et ajouter des produits';
}

export class PopOverConstant {
    static POP_TITLE = 'AIDE';
    static PRODUCT_CATEGORY_PARENT = `Lors de la création d'une sous-catégorie, <br> veuillez d'abord sélectionner sa catégorie parente.`;
}

export class ProductPopover {
    static PRODUCT_BASIC_DETAIL = `Fournissez les informations essentielles sur le produit, telles que sa catégorie, son titre, etc.`;
    static PRODUCT_BRAND = `Indiquez la marque ou le fabricant du produit. <br> Entrez le nom de l'entreprise ou de la marque qui produit ou commercialise le produit.`;
    static PRODUCT_SKU = `Saisissez l'identifiant unique Stock Keeping Unit (SKU) du produit. <br> Le SKU est un identifiant distinct utilisé pour suivre les stocks et gérer les variations du produit.`;
    static PRODUCT_UNIT_MEASURE = `Spécifiez l'unité de mesure du produit. <br> Il s'agit de l'unité standard utilisée pour quantifier ou mesurer la quantité ou la taille du produit. <br> Exemples : kilogrammes (kg), mètres (m), litres (L), ou pièces (pcs).`;
    static PRODUCT_STATUS = `Indiquez l'état actuel du produit. <br> Sélectionnez l'option appropriée qui reflète la disponibilité ou la condition du produit.`;
    static PRODUCT_IS_SERVICE = `Si cet article est un service, sélectionnez cette option. <br> Les services ne nécessitent pas de gestion de stock ni de quantité d'inventaire.`;
    static PRODUCT_DESCRIPTION = `Fournissez une description brève et informative du produit.`;
    // prix
    static PRODUCT_PRICE_DETAIL = `Pour garantir une tarification précise et des calculs fiscaux corrects pour vos produits, <br> il est essentiel de bien configurer les paramètres de prix et de taxe.`;
}
