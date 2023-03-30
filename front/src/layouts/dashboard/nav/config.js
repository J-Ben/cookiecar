// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------

const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

const navConfig = [
  {
    title: 'Voitures',
    path: '/dashboard/products',
    // icon: icon('ic_cart'),
  }, {
    title: 'Passagers',
    path: '/dashboard/user',
    icon: icon('ic_user'),
  },

  {
    title: 'Voiture & Passagers',
    path: '/dashboard/blog',
    icon: icon('ic_blog'),
  },
  {
    title: 'A propos',
    path: '/login',
    icon: icon('ic_lock'),
  },

];

export default navConfig;
